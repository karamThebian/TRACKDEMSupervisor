package com.example.trackdem;

public class MissionHelperClass {
    String From, To, Description,Arrival,AssistantName,ConfirmedShipment,Delivering,Departure,DriverName,GPS,MissionId,Notes,Status,UnitAvailable,CancelStatus;

    public MissionHelperClass() {
    }

    public MissionHelperClass(String From, String To, String Description, String Arrival, String AssistantName, String ConfirmedShipment, String Delivering, String Departure, String DriverName, String GPS, String MissionId, String Notes, String Status, String UnitAvailable, String CancelStatus) {
        this.From = From;
        this.To = To;
        this.Description = Description;
        this.Arrival = Arrival;
        this.AssistantName = AssistantName;
        this.ConfirmedShipment = ConfirmedShipment;
        this.Delivering = Delivering;
        this.Departure = Departure;
        this.DriverName = DriverName;
        this.GPS = GPS;
        this.MissionId = MissionId;
        this.Notes = Notes;
        this.Status = Status;
        this.UnitAvailable = UnitAvailable;
        this.CancelStatus = CancelStatus;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    public String getAssistantName() {
        return AssistantName;
    }

    public void setAssistantName(String assistantName) {
        AssistantName = assistantName;
    }

    public String getConfirmedShipment() {
        return ConfirmedShipment;
    }

    public void setConfirmedShipment(String confirmedShipment) {
        ConfirmedShipment = confirmedShipment;
    }

    public String getDelivering() {
        return Delivering;
    }

    public void setDelivering(String delivering) {
        Delivering = delivering;
    }

    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = departure;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getMissionId() {
        return MissionId;
    }

    public void setMissionId(String missionId) {
        MissionId = missionId;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUnitAvailable() {
        return UnitAvailable;
    }

    public void setUnitAvailable(String unitAvailable) {
        UnitAvailable = unitAvailable;
    }

    public String getCancelStatus() {
        return CancelStatus;
    }

    public void setCancelStatus(String cancelStatus) {
        CancelStatus = cancelStatus;
    }
}