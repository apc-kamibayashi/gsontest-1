package com.bookvideo.library.domain;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Device {
    private int location = 0;
    private List<Location> locations;
    @SerializedName("lastRest")
    private String lastRestaurant;
    private DeviceStatus status;
    private Battery battery;
    @SerializedName("bvUpdate")
    private List<ApplicationStatus> appStatusList = new ArrayList<>();
    @SerializedName("updater")
    private List<ApplicationStatus> updaterStatusList = new ArrayList<>();
    @SerializedName("bvData")
    private List<ApplicationStatus> dataStatusList = new ArrayList<>();

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public String getLastRestaurant() {
        return lastRestaurant;
    }

    public void setLastRestaurant(String lastRestaurant) {
        this.lastRestaurant = lastRestaurant;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public List<ApplicationStatus> getAppStatusList() {
        return Collections.unmodifiableList(appStatusList);
    }

    public void addAppStatus(ApplicationStatus status) {
        appStatusList.add(status);
    }


    public List<ApplicationStatus> getUpdaterStatusList() {
        return Collections.unmodifiableList(updaterStatusList);
    }

    public void addUpdaterStatusList(ApplicationStatus status) {
        updaterStatusList.add(status);
    }

    public List<ApplicationStatus> getDataStatusList() {
        return Collections.unmodifiableList(dataStatusList);
    }

    public void addDataStatusList(ApplicationStatus status) {
        dataStatusList.add(status);
    }

    public static class Location {
        private LocationType type;
        private int settedAt;
        private String location;

        public Location() {

        }

        public Location(LocationType type, int settedAt, String location) {
            this.type = type;
            this.settedAt = settedAt;
            this.location = location;
        }

        public LocationType getType() {
            return type;
        }

        public int getSettedAt() {
            return settedAt;
        }

        public String getLocation() {
            return location;
        }
    }

    public static class Battery {
        private int level;
        private BatteryStatus status;
        @SerializedName("pluggedTime")
        private List<Integer> pluggedTimes = new ArrayList<>();
        @SerializedName("displuggedTime")
        private List<Integer> displuggedTimes = new ArrayList<>();
        private BatteryHealth health;

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public BatteryStatus getStatus() {
            return status;
        }

        public void setStatus(BatteryStatus status) {
            this.status = status;
        }

        public List<Integer> getPluggedTimes() {
            return Collections.unmodifiableList(pluggedTimes);
        }

        public void addPluggedTime(int pluggedTime) {
            pluggedTimes.add(pluggedTime);
        }

        public List<Integer> getDispluggedTimes() {
            return Collections.unmodifiableList(displuggedTimes);
        }

        public void addDispluggedTime(int displuggedTime) {
            displuggedTimes.add(displuggedTime);
        }

        public BatteryHealth getHealth() {
            return health;
        }

        public void setHealth(BatteryHealth health) {
            this.health = health;
        }
    }

    public static class ApplicationStatus {
        private int installedTime;
        private int version;
        private int openedTime;

        public ApplicationStatus() {
            this(0, 0, 0);
        }

        public ApplicationStatus(int version, int installedtime) {
            this(version, installedtime, 0);

        }

        public ApplicationStatus(int version, int installedTime, int openedTime) {
            this.version = version;
            this.installedTime = installedTime;
            this.openedTime = openedTime;
        }

        public int getInstalledTime() {
            return installedTime;
        }

        public void setInstalledTime(int installedTime) {
            this.installedTime = installedTime;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public int getOpenedTime() {
            return openedTime;
        }

        public void setOpenedTime(int openedTime) {
            this.openedTime = openedTime;
        }
    }

    public enum LocationType {
        RESTAURANT(0),
        OFFICE(1);

        private int typeValue;
        private LocationType(int typeValue) {
            this.typeValue = typeValue;
        }

        public int getLocationValue() {
            return typeValue;
        }

        public static LocationType valueOf(int typeValue) {
            for (LocationType location: LocationType.values()) {
                if (location.getLocationValue() == typeValue) {
                    return location;
                }
            }
            throw new IllegalArgumentException("unknown value " + typeValue);
        }
    }

    public enum DeviceStatus {
        OFFLINE, ONLINE
    }

    public enum BatteryStatus {
        UNKNOWN, CHARGING, DISCHARGING, NOT_CHARGING, FULL
    }

    public enum BatteryHealth {
        UNKNOWN, GOOD, OVERHEAT, DEAD, OVER_VOLTAGE, UNSPECIFIED_FAILURE, COLD
    }
}
