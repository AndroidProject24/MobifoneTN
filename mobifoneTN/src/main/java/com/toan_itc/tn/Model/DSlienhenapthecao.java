
package com.toan_itc.tn.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

@Generated("org.jsonschema2pojo")
public class DSlienhenapthecao extends RealmObject{
    @PrimaryKey
    @SerializedName("idTheCao")
    @Expose
    private String idTheCao;
    @SerializedName("idLienHe")
    @Expose
    private String idLienHe;
    @SerializedName("SDT")
    @Expose
    private String SDT;
    @SerializedName("TKNH")
    @Expose
    private String TKNH;
    @SerializedName("TenTK")
    @Expose
    private String TenTK;
    @SerializedName("TenNH")
    @Expose
    private String TenNH;

    /**
     * 
     * @return
     *     The idTheCao
     */
    public String getIdTheCao() {
        return idTheCao;
    }

    /**
     * 
     * @param idTheCao
     *     The idTheCao
     */
    public void setIdTheCao(String idTheCao) {
        this.idTheCao = idTheCao;
    }

    /**
     * 
     * @return
     *     The idLienHe
     */
    public String getIdLienHe() {
        return idLienHe;
    }

    /**
     * 
     * @param idLienHe
     *     The idLienHe
     */
    public void setIdLienHe(String idLienHe) {
        this.idLienHe = idLienHe;
    }

    /**
     * 
     * @return
     *     The SDT
     */
    public String getSDT() {
        return SDT;
    }

    /**
     * 
     * @param SDT
     *     The SDT
     */
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    /**
     * 
     * @return
     *     The TKNH
     */
    public String getTKNH() {
        return TKNH;
    }

    /**
     * 
     * @param TKNH
     *     The TKNH
     */
    public void setTKNH(String TKNH) {
        this.TKNH = TKNH;
    }

    /**
     * 
     * @return
     *     The TenTK
     */
    public String getTenTK() {
        return TenTK;
    }

    /**
     * 
     * @param TenTK
     *     The TenTK
     */
    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    /**
     * 
     * @return
     *     The TenNH
     */
    public String getTenNH() {
        return TenNH;
    }

    /**
     * 
     * @param TenNH
     *     The TenNH
     */
    public void setTenNH(String TenNH) {
        this.TenNH = TenNH;
    }

}
