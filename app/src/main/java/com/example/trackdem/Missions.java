package com.example.trackdem;

public class Missions {
    private String MissionId;
    private String LocationFrom;
    private String LocationTo;
    private String Description;
    private String Status;
    private String DriverName;
    private String AssistantName;
    private String GPSLocation;
    private String Notes;
    private String ConfirmedShipment;

    public Missions(String missionId, String locationFrom, String locationTo, String description, String status, String driverName, String assistantName, String GPSLocation, String notes, String confirmedShipment) {
        MissionId = missionId;
        LocationFrom = locationFrom;
        LocationTo = locationTo;
        Description = description;
        Status = status;
        DriverName = driverName;
        AssistantName = assistantName;
        this.GPSLocation = GPSLocation;
        Notes = notes;
        ConfirmedShipment = confirmedShipment;
    }

    public String getMissionId() {
        return MissionId;
    }

    public void setMissionId(String missionId) {
        MissionId = missionId;
    }

    public String getLocationFrom() {
        return LocationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        LocationFrom = locationFrom;
    }

    public String getLocationTo() {
        return LocationTo;
    }

    public void setLocationTo(String locationTo) {
        LocationTo = locationTo;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getAssistantName() {
        return AssistantName;
    }

    public void setAssistantName(String assistantName) {
        AssistantName = assistantName;
    }

    public String getGPSLocation() {
        return GPSLocation;
    }

    public void setGPSLocation(String GPSLocation) {
        this.GPSLocation = GPSLocation;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getConfirmedShipment() {
        return ConfirmedShipment;
    }

    public void setConfirmedShipment(String confirmedShipment) {
        ConfirmedShipment = confirmedShipment;
    }
}
