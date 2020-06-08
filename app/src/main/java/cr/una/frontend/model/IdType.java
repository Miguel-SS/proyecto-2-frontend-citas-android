package cr.una.frontend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IdType {

    @JsonProperty("$oid")
    private String $oid;

    /**
     *
     */
    public IdType() {
    }

    /**
     *
     * @param $oid $oid
     */
    public IdType(String $oid) {
        this.$oid = $oid;
    }

    /**
     *
     * @return $oid
     */
    public String get$oid() {
        return $oid;
    }

    /**
     *
     * @param $oid $oid
     */
    public void set$oid(String $oid) {
        this.$oid = $oid;
    }

    /**
     * toString
     * @return attributes of IdType
     */
    @Override
    public String toString() {
        return "IdType{" + "$oid=" + $oid + '}';
    }
}
