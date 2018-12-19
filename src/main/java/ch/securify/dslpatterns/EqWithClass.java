package ch.securify.dslpatterns;

import ch.securify.analysis.DSLAnalysis;
import ch.securify.decompiler.Variable;
import ch.securify.dslpatterns.datalogpattern.DatalogElem;
import ch.securify.dslpatterns.util.DSLLabel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Equality between a variable and a Class (e.g.: X = callvalue)
 */
public class EqWithClass extends AbstractDSLPattern implements DatalogElem {
    private Variable v1;
    private Class classtype;

    public EqWithClass(Variable v1, Class classtype) {
        this.v1 = v1;
        this.classtype = classtype;
    }

    /**
     * @return a string description of the equality
     */
    @Override
    public String getStringRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append(v1.getName());
        sb.append(" = ");
        sb.append(classtype.getSimpleName());
        return sb.toString();
    }


    @Override
    public String getDatalogStringRep(DSLAnalysis analyzer) {
        StringBuilder sb = new StringBuilder();
        sb.append(v1.getName());
        sb.append(" = ");
        sb.append(analyzer.getCode(classtype));
        return sb.toString();
    }

    @Override
    public Set<Variable> getVariables() {
        Set<Variable> vars = new HashSet<>(1);
        vars.add(v1);

        return vars;
    }

    @Override
    public Set<DSLLabel> getLabels() {
        return new HashSet<>();
    }
}