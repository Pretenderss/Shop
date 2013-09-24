/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeshop.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@Entity
@XmlRootElement(name = "shop")
@XmlType(propOrder = {"id", "nameOfPoint","phone", "latitude", "longitude"})
public class PointOfService implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private static final long serialVersionUID = 1L;
    private static Long pointsNumber = 0L;
    private double latitude, longitude;
    private String nameOfPoint;
    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setNameOfPoint(String nameOfPoint) {
        this.nameOfPoint = nameOfPoint;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getNameOfPoint() {
        return nameOfPoint;
    }

    protected PointOfService() {
    }

    public PointOfService(double latitude, double longitude, 
            String nameOfPoint, String phone) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.nameOfPoint = nameOfPoint;
        this.phone = phone;
        id = ++pointsNumber;
    }

    public static Long getPointsNumber() {
        return pointsNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PointOfService)) {
            return false;
        }
        PointOfService other = (PointOfService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Name of point=" + nameOfPoint + "\nLongitude=" + longitude + 
                "\nLatitude=" + latitude + "\nid=" + id + " ]";
    }
    
}
