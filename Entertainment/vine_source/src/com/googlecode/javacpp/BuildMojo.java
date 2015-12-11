// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

// Referenced classes of package com.googlecode.javacpp:
//            Builder

public class BuildMojo extends AbstractMojo
{

    private String classOrPackageName;
    private String classOrPackageNames[];
    private String classPath;
    private String classPaths[];
    private boolean compile;
    private String compilerOptions[];
    private boolean copyLibs;
    private Map environmentVariables;
    private boolean header;
    private String jarPrefix;
    private File outputDirectory;
    private String outputName;
    private String properties;
    private File propertyFile;
    private Properties propertyKeysAndValues;
    private boolean skip;

    public BuildMojo()
    {
        classPath = null;
        classPaths = null;
        outputDirectory = null;
        outputName = null;
        compile = true;
        header = false;
        copyLibs = false;
        jarPrefix = null;
        properties = null;
        propertyFile = null;
        propertyKeysAndValues = null;
        classOrPackageName = null;
        classOrPackageNames = null;
        environmentVariables = null;
        compilerOptions = null;
        skip = false;
    }

    public void execute()
        throws MojoExecutionException
    {
        try
        {
            getLog().info("Executing JavaCPP Builder");
            if (getLog().isDebugEnabled())
            {
                getLog().debug((new StringBuilder()).append("classPath: ").append(classPath).toString());
                getLog().debug((new StringBuilder()).append("classPaths: ").append(Arrays.deepToString(classPaths)).toString());
                getLog().debug((new StringBuilder()).append("outputDirectory: ").append(outputDirectory).toString());
                getLog().debug((new StringBuilder()).append("outputName: ").append(outputName).toString());
                getLog().debug((new StringBuilder()).append("compile: ").append(compile).toString());
                getLog().debug((new StringBuilder()).append("header: ").append(header).toString());
                getLog().debug((new StringBuilder()).append("copyLibs: ").append(copyLibs).toString());
                getLog().debug((new StringBuilder()).append("jarPrefix: ").append(jarPrefix).toString());
                getLog().debug((new StringBuilder()).append("properties: ").append(properties).toString());
                getLog().debug((new StringBuilder()).append("propertyFile: ").append(propertyFile).toString());
                getLog().debug((new StringBuilder()).append("propertyKeysAndValues: ").append(propertyKeysAndValues).toString());
                getLog().debug((new StringBuilder()).append("classOrPackageName: ").append(classOrPackageName).toString());
                getLog().debug((new StringBuilder()).append("classOrPackageNames: ").append(Arrays.deepToString(classOrPackageNames)).toString());
                getLog().debug((new StringBuilder()).append("environmentVariables: ").append(environmentVariables).toString());
                getLog().debug((new StringBuilder()).append("compilerOptions: ").append(Arrays.deepToString(compilerOptions)).toString());
                getLog().debug((new StringBuilder()).append("skip: ").append(skip).toString());
            }
            if (skip)
            {
                getLog().info("Skipped execution of JavaCPP Builder");
                return;
            }
        }
        catch (Exception exception)
        {
            getLog().error((new StringBuilder()).append("Failed to execute JavaCPP Builder: ").append(exception.getMessage()).toString());
            throw new MojoExecutionException("Failed to execute JavaCPP Builder", exception);
        }
        if (classPaths == null || classPath == null) goto _L2; else goto _L1
_L1:
        classPaths = (String[])Arrays.copyOf(classPaths, classPaths.length + 1);
        classPaths[classPaths.length - 1] = classPath;
_L9:
        if (classOrPackageNames == null || classOrPackageName == null) goto _L4; else goto _L3
_L3:
        classOrPackageNames = (String[])Arrays.copyOf(classOrPackageNames, classOrPackageNames.length + 1);
        classOrPackageNames[classOrPackageNames.length - 1] = classOrPackageName;
_L7:
        File afile[] = (new Builder()).classPaths(classPaths).outputDirectory(outputDirectory).outputName(outputName).compile(compile).header(header).copyLibs(copyLibs).jarPrefix(jarPrefix).properties(properties).propertyFile(propertyFile).properties(propertyKeysAndValues).classesOrPackages(classOrPackageNames).environmentVariables(environmentVariables).compilerOptions(compilerOptions).build();
        getLog().info("Successfully executed JavaCPP Builder");
        if (getLog().isDebugEnabled())
        {
            getLog().debug((new StringBuilder()).append("outputFiles: ").append(Arrays.deepToString(afile)).toString());
            return;
        }
          goto _L5
_L2:
        if (classPath != null)
        {
            classPaths = (new String[] {
                classPath
            });
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (classOrPackageName == null) goto _L7; else goto _L6
_L6:
        classOrPackageNames = (new String[] {
            classOrPackageName
        });
          goto _L7
_L5:
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
