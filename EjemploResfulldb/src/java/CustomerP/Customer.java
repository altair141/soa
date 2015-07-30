/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerP;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String address;
    private Integer op;

    public Customer() {
    }

    public Customer(Integer id) {
        this.id = id;

    }

    public Customer(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }
}
