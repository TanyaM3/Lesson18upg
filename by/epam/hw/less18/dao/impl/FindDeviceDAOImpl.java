package by.epam.hw.less18.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import by.epam.hw.less18.dao.DAOException;
import by.epam.hw.less18.dao.DeviceDAO;
import by.epam.hw.less18.dao.DeviceDataMatcher;
import by.epam.hw.less18.dao.DeviceMaker;
import by.epam.hw.less18.dao.DeviceReader;
import by.epam.hw.less18.entity.Device;
import by.epam.hw.less18.entity.criteria.Criteria;

public class FindDeviceDAOImpl implements DeviceDAO {
	private String path = "devices.txt";

	@Override
	public List<Device> find(Criteria criteria) throws DAOException {
		List<Device> devices = new ArrayList<Device>();
		List<String> dataFromSource = null;
		DeviceReader deviceReader = new DeviceReader(path);
		
		if (criteria.getGroupSearchName() != null) {
			try {
				dataFromSource = deviceReader.take(criteria.getGroupSearchName());
			} catch (IOException e) {
				throw new DAOException(e);
			}
		} else {
			try {
				dataFromSource = deviceReader.take();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		DeviceDataMatcher matcher = new DeviceDataMatcher(dataFromSource, criteria);
		List<String> dataAfterMatching = matcher.match();

		DeviceMaker devicesMaker = new DeviceMaker();
		devices = devicesMaker.makeListOfDevices(dataAfterMatching);

		return devices;
	}
}
