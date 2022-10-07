package by.epam.hw.less18.dao;

import java.util.ArrayList;
import java.util.List;

import by.epam.hw.less18.entity.Device;
import by.epam.hw.less18.entity.Laptop;
import by.epam.hw.less18.entity.Oven;
import by.epam.hw.less18.entity.Refrigerator;
import by.epam.hw.less18.entity.Speakers;
import by.epam.hw.less18.entity.TabletPC;
import by.epam.hw.less18.entity.VacuumCleaner;

public class DevicesMaker {
	public List<Device> makeListOfDevices(List<String> dataAfterMatching) {
		List<Device> devices = new ArrayList<Device>();

		for (int i = 0; i < dataAfterMatching.size(); i++) {
			String stringData[] = dataAfterMatching.get(i).split(":|,\\s+|=");
			String type = stringData[0];
			switch (type) {
			case "Oven ":
				Oven oven = new Oven();
				oven.setType("Oven");
				oven.setPowerConsumption(Integer.parseInt(stringData[2]));
				oven.setWeight(Integer.parseInt(stringData[4]));
				oven.setCapacity(Integer.parseInt(stringData[6]));
				oven.setDepth(Integer.parseInt(stringData[8]));
				oven.setHeight(Integer.parseInt(stringData[10]));
				oven.setWidth(Integer.parseInt(stringData[12]));
				devices.add(oven);
				break;
			case "Laptop ":
				Laptop laptop = new Laptop();
				laptop.setType("Laptop");
				laptop.setBatteryCapacity(Integer.parseInt(stringData[2]));
				laptop.setOs(stringData[4]);
				laptop.setMemoryRom(Integer.parseInt(stringData[6]));
				laptop.setSystemMemory(Integer.parseInt(stringData[8]));
				laptop.setCpu(Double.parseDouble(stringData[10]));
				laptop.setDisplayInchs(Double.parseDouble(stringData[12]));
				devices.add(laptop);
				break;
			case "Refrigerator ":
				Refrigerator refrigerator = new Refrigerator();
				refrigerator.setType("Refrigerator");
				refrigerator.setPowerConsumption(Integer.parseInt(stringData[2]));
				refrigerator.setWeight(Integer.parseInt(stringData[4]));
				refrigerator.setFreezerCapacity(Integer.parseInt(stringData[6]));
				refrigerator.setOverallCapacity(Integer.parseInt(stringData[8]));
				refrigerator.setHeight(Integer.parseInt(stringData[10]));
				refrigerator.setWidth(Integer.parseInt(stringData[12]));
				devices.add(refrigerator);
				break;
			case "VacuumCleaner ":
				VacuumCleaner cleaner = new VacuumCleaner();
				cleaner.setType("Vacuum Cleaner");
				cleaner.setPowerConsumptiom(Integer.parseInt(stringData[2]));
				cleaner.setFilterType(stringData[4]);
				cleaner.setBagType(stringData[6]);
				cleaner.setWandType(stringData[8]);
				cleaner.setMotorSpeedRegulation(Integer.parseInt(stringData[10]));
				cleaner.setCleaningWidth(Integer.parseInt(stringData[12]));
				devices.add(cleaner);
				break;
			case "TabletPC ":
				TabletPC pc = new TabletPC();
				pc.setType("Tablet PC");
				pc.setBatteryCapacity(Integer.parseInt(stringData[2]));
				pc.setDisplayInches(Integer.parseInt(stringData[4]));
				pc.setMemoryRom(Integer.parseInt(stringData[6]));
				pc.setFlashMemoryCapacity(Integer.parseInt(stringData[8]));
				pc.setColor(stringData[10]);
				devices.add(pc);
				break;
			case "Speakers ":
				Speakers speakers = new Speakers();
				speakers.setType("Speakers");
				speakers.setPowerConsumption(Integer.parseInt(stringData[2]));
				speakers.setNumberOfSpeakers(Integer.parseInt(stringData[4]));
				speakers.setFrequencyRange(stringData[6]);
				speakers.setCordLength(Integer.parseInt(stringData[8]));
				devices.add(speakers);
				break;
			}
		}
		return devices;
	}
}
