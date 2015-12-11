.class public Lorg/apache/log4j/helpers/OptionConverter;
.super Ljava/lang/Object;
.source "OptionConverter.java"


# static fields
.field static DELIM_START:Ljava/lang/String;

.field static DELIM_START_LEN:I

.field static DELIM_STOP:C

.field static DELIM_STOP_LEN:I

.field static class$java$lang$String:Ljava/lang/Class;

.field static class$org$apache$log4j$Level:Ljava/lang/Class;

.field static class$org$apache$log4j$spi$Configurator:Ljava/lang/Class;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    const-string v0, "${"

    sput-object v0, Lorg/apache/log4j/helpers/OptionConverter;->DELIM_START:Ljava/lang/String;

    .line 43
    const/16 v0, 0x7d

    sput-char v0, Lorg/apache/log4j/helpers/OptionConverter;->DELIM_STOP:C

    .line 44
    const/4 v0, 0x2

    sput v0, Lorg/apache/log4j/helpers/OptionConverter;->DELIM_START_LEN:I

    .line 45
    const/4 v0, 0x1

    sput v0, Lorg/apache/log4j/helpers/OptionConverter;->DELIM_STOP_LEN:I

    return-void
.end method

.method static class$(Ljava/lang/String;)Ljava/lang/Class;
    .locals 3
    .param p0, "x0"    # Ljava/lang/String;

    .prologue
    .line 219
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    :catch_0
    move-exception v0

    .local v0, "x1":Ljava/lang/ClassNotFoundException;
    new-instance v1, Ljava/lang/NoClassDefFoundError;

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/NoClassDefFoundError;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static findAndSubst(Ljava/lang/String;Ljava/util/Properties;)Ljava/lang/String;
    .locals 4
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "props"    # Ljava/util/Properties;

    .prologue
    .line 298
    invoke-virtual {p1, p0}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 299
    .local v1, "value":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 300
    const/4 v1, 0x0

    .line 306
    .end local v1    # "value":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 303
    .restart local v1    # "value":Ljava/lang/String;
    :cond_0
    :try_start_0
    invoke-static {v1, p1}, Lorg/apache/log4j/helpers/OptionConverter;->substVars(Ljava/lang/String;Ljava/util/Properties;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 304
    :catch_0
    move-exception v0

    .line 305
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Bad option value ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v0}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static getSystemProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "def"    # Ljava/lang/String;

    .prologue
    .line 103
    :try_start_0
    invoke-static {p0, p1}, Ljava/lang/System;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    .line 106
    .end local p1    # "def":Ljava/lang/String;
    :goto_0
    return-object p1

    .line 104
    .restart local p1    # "def":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 105
    .local v0, "e":Ljava/lang/Throwable;
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "Was not allowed to read system property \""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, "\"."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/apache/log4j/helpers/LogLog;->debug(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static instantiateByClassName(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p0, "className"    # Ljava/lang/String;
    .param p1, "superClass"    # Ljava/lang/Class;
    .param p2, "defaultValue"    # Ljava/lang/Object;

    .prologue
    .line 324
    if-eqz p0, :cond_0

    .line 326
    :try_start_0
    invoke-static {p0}, Lorg/apache/log4j/helpers/Loader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 327
    .local v0, "classObj":Ljava/lang/Class;
    invoke-virtual {p1, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 328
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "A \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "\" object is not assignable to a \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "\" variable."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;)V

    .line 330
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "The class \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "\" was loaded by "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;)V

    .line 331
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "] whereas object of type "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;)V

    .line 332
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "\" was loaded by ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;)V

    .line 347
    .end local v0    # "classObj":Ljava/lang/Class;
    .end local p2    # "defaultValue":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-object p2

    .line 336
    .restart local v0    # "classObj":Ljava/lang/Class;
    .restart local p2    # "defaultValue":Ljava/lang/Object;
    :cond_1
    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object p2

    goto :goto_0

    .line 337
    .end local v0    # "classObj":Ljava/lang/Class;
    :catch_0
    move-exception v1

    .line 338
    .local v1, "e":Ljava/lang/ClassNotFoundException;
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Could not instantiate class ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v1}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 339
    .end local v1    # "e":Ljava/lang/ClassNotFoundException;
    :catch_1
    move-exception v1

    .line 340
    .local v1, "e":Ljava/lang/IllegalAccessException;
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Could not instantiate class ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v1}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 341
    .end local v1    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v1

    .line 342
    .local v1, "e":Ljava/lang/InstantiationException;
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Could not instantiate class ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v1}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 343
    .end local v1    # "e":Ljava/lang/InstantiationException;
    :catch_3
    move-exception v1

    .line 344
    .local v1, "e":Ljava/lang/RuntimeException;
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Could not instantiate class ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v1}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static instantiateByKey(Ljava/util/Properties;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p0, "props"    # Ljava/util/Properties;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "superClass"    # Ljava/lang/Class;
    .param p3, "defaultValue"    # Ljava/lang/Object;

    .prologue
    .line 117
    invoke-static {p1, p0}, Lorg/apache/log4j/helpers/OptionConverter;->findAndSubst(Ljava/lang/String;Ljava/util/Properties;)Ljava/lang/String;

    move-result-object v0

    .line 118
    .local v0, "className":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 119
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "Could not find value for key "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;)V

    .line 123
    .end local p3    # "defaultValue":Ljava/lang/Object;
    :goto_0
    return-object p3

    .restart local p3    # "defaultValue":Ljava/lang/Object;
    :cond_0
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p2, p3}, Lorg/apache/log4j/helpers/OptionConverter;->instantiateByClassName(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p3

    goto :goto_0
.end method

.method public static selectAndConfigure(Ljava/net/URL;Ljava/lang/String;Lorg/apache/log4j/spi/LoggerRepository;)V
    .locals 4
    .param p0, "url"    # Ljava/net/URL;
    .param p1, "clazz"    # Ljava/lang/String;
    .param p2, "hierarchy"    # Lorg/apache/log4j/spi/LoggerRepository;

    .prologue
    .line 463
    const/4 v0, 0x0

    .line 464
    .local v0, "configurator":Lorg/apache/log4j/spi/Configurator;
    invoke-virtual {p0}, Ljava/net/URL;->getFile()Ljava/lang/String;

    move-result-object v1

    .line 466
    .local v1, "filename":Ljava/lang/String;
    if-nez p1, :cond_0

    if-eqz v1, :cond_0

    const-string v2, ".xml"

    invoke-virtual {v1, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 467
    const-string p1, "org.apache.log4j.xml.DOMConfigurator"

    .line 470
    :cond_0
    if-eqz p1, :cond_2

    .line 471
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Preferred configurator class: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/apache/log4j/helpers/LogLog;->debug(Ljava/lang/String;)V

    .line 472
    sget-object v2, Lorg/apache/log4j/helpers/OptionConverter;->class$org$apache$log4j$spi$Configurator:Ljava/lang/Class;

    if-nez v2, :cond_1

    const-string v2, "org.apache.log4j.spi.Configurator"

    invoke-static {v2}, Lorg/apache/log4j/helpers/OptionConverter;->class$(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    sput-object v2, Lorg/apache/log4j/helpers/OptionConverter;->class$org$apache$log4j$spi$Configurator:Ljava/lang/Class;

    :goto_0
    const/4 v3, 0x0

    invoke-static {p1, v2, v3}, Lorg/apache/log4j/helpers/OptionConverter;->instantiateByClassName(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "configurator":Lorg/apache/log4j/spi/Configurator;
    check-cast v0, Lorg/apache/log4j/spi/Configurator;

    .line 475
    .restart local v0    # "configurator":Lorg/apache/log4j/spi/Configurator;
    if-nez v0, :cond_3

    .line 476
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const-string v3, "Could not instantiate configurator ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, "]."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/apache/log4j/helpers/LogLog;->error(Ljava/lang/String;)V

    .line 484
    :goto_1
    return-void

    .line 472
    :cond_1
    sget-object v2, Lorg/apache/log4j/helpers/OptionConverter;->class$org$apache$log4j$spi$Configurator:Ljava/lang/Class;

    goto :goto_0

    .line 480
    :cond_2
    new-instance v0, Lorg/apache/log4j/PropertyConfigurator;

    .end local v0    # "configurator":Lorg/apache/log4j/spi/Configurator;
    invoke-direct {v0}, Lorg/apache/log4j/PropertyConfigurator;-><init>()V

    .line 483
    .restart local v0    # "configurator":Lorg/apache/log4j/spi/Configurator;
    :cond_3
    invoke-interface {v0, p0, p2}, Lorg/apache/log4j/spi/Configurator;->doConfigure(Ljava/net/URL;Lorg/apache/log4j/spi/LoggerRepository;)V

    goto :goto_1
.end method

.method public static substVars(Ljava/lang/String;Ljava/util/Properties;)Ljava/lang/String;
    .locals 10
    .param p0, "val"    # Ljava/lang/String;
    .param p1, "props"    # Ljava/util/Properties;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    const/4 v8, -0x1

    .line 391
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    .line 393
    .local v6, "sbuf":Ljava/lang/StringBuffer;
    const/4 v0, 0x0

    .line 397
    .local v0, "i":I
    :goto_0
    sget-object v7, Lorg/apache/log4j/helpers/OptionConverter;->DELIM_START:Ljava/lang/String;

    invoke-virtual {p0, v7, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v1

    .line 398
    .local v1, "j":I
    if-ne v1, v8, :cond_1

    .line 400
    if-nez v0, :cond_0

    .line 404
    .end local p0    # "val":Ljava/lang/String;
    :goto_1
    return-object p0

    .line 403
    .restart local p0    # "val":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v7

    invoke-virtual {p0, v0, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 404
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object p0

    goto :goto_1

    .line 407
    :cond_1
    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 408
    sget-char v7, Lorg/apache/log4j/helpers/OptionConverter;->DELIM_STOP:C

    invoke-virtual {p0, v7, v1}, Ljava/lang/String;->indexOf(II)I

    move-result v2

    .line 409
    .local v2, "k":I
    if-ne v2, v8, :cond_2

    .line 410
    new-instance v7, Ljava/lang/IllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuffer;

    invoke-direct {v8}, Ljava/lang/StringBuffer;-><init>()V

    const/16 v9, 0x22

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v8, p0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    const-string v9, "\" has no closing brace. Opening brace at position "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v8

    const/16 v9, 0x2e

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 414
    :cond_2
    sget v7, Lorg/apache/log4j/helpers/OptionConverter;->DELIM_START_LEN:I

    add-int/2addr v1, v7

    .line 415
    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 417
    .local v3, "key":Ljava/lang/String;
    const/4 v7, 0x0

    invoke-static {v3, v7}, Lorg/apache/log4j/helpers/OptionConverter;->getSystemProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 419
    .local v5, "replacement":Ljava/lang/String;
    if-nez v5, :cond_3

    if-eqz p1, :cond_3

    .line 420
    invoke-virtual {p1, v3}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 423
    :cond_3
    if-eqz v5, :cond_4

    .line 429
    invoke-static {v5, p1}, Lorg/apache/log4j/helpers/OptionConverter;->substVars(Ljava/lang/String;Ljava/util/Properties;)Ljava/lang/String;

    move-result-object v4

    .line 430
    .local v4, "recursiveReplacement":Ljava/lang/String;
    invoke-virtual {v6, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 432
    .end local v4    # "recursiveReplacement":Ljava/lang/String;
    :cond_4
    sget v7, Lorg/apache/log4j/helpers/OptionConverter;->DELIM_STOP_LEN:I

    add-int v0, v2, v7

    .line 433
    goto :goto_0
.end method

.method public static toBoolean(Ljava/lang/String;Z)Z
    .locals 2
    .param p0, "value"    # Ljava/lang/String;
    .param p1, "dEfault"    # Z

    .prologue
    .line 137
    if-nez p0, :cond_1

    .line 144
    .end local p1    # "dEfault":Z
    :cond_0
    :goto_0
    return p1

    .line 139
    .restart local p1    # "dEfault":Z
    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 140
    .local v0, "trimmedVal":Ljava/lang/String;
    const-string v1, "true"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 141
    const/4 p1, 0x1

    goto :goto_0

    .line 142
    :cond_2
    const-string v1, "false"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 143
    const/4 p1, 0x0

    goto :goto_0
.end method

.method public static toLevel(Ljava/lang/String;Lorg/apache/log4j/Level;)Lorg/apache/log4j/Level;
    .locals 14
    .param p0, "value"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Lorg/apache/log4j/Level;

    .prologue
    const/4 v11, 0x0

    const/4 v13, 0x0

    .line 186
    if-nez p0, :cond_0

    .line 252
    .end local p1    # "defaultValue":Lorg/apache/log4j/Level;
    :goto_0
    return-object p1

    .line 189
    .restart local p1    # "defaultValue":Lorg/apache/log4j/Level;
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    .line 191
    const/16 v12, 0x23

    invoke-virtual {p0, v12}, Ljava/lang/String;->indexOf(I)I

    move-result v4

    .line 192
    .local v4, "hashIndex":I
    const/4 v12, -0x1

    if-ne v4, v12, :cond_2

    .line 193
    const-string v12, "NULL"

    invoke-virtual {v12, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_1

    move-object p1, v11

    .line 194
    goto :goto_0

    .line 197
    :cond_1
    invoke-static {p0, p1}, Lorg/apache/log4j/Level;->toLevel(Ljava/lang/String;Lorg/apache/log4j/Level;)Lorg/apache/log4j/Level;

    move-result-object p1

    goto :goto_0

    .line 201
    :cond_2
    move-object v9, p1

    .line 203
    .local v9, "result":Lorg/apache/log4j/Level;
    add-int/lit8 v12, v4, 0x1

    invoke-virtual {p0, v12}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 204
    .local v1, "clazz":Ljava/lang/String;
    invoke-virtual {p0, v13, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    .line 207
    .local v5, "levelName":Ljava/lang/String;
    const-string v12, "NULL"

    invoke-virtual {v12, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v12

    if-eqz v12, :cond_3

    move-object p1, v11

    .line 208
    goto :goto_0

    .line 211
    :cond_3
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    const-string v12, "toLevel:class=["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, "]"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, ":pri=["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, "]"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lorg/apache/log4j/helpers/LogLog;->debug(Ljava/lang/String;)V

    .line 215
    :try_start_0
    invoke-static {v1}, Lorg/apache/log4j/helpers/Loader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    .line 219
    .local v2, "customLevel":Ljava/lang/Class;
    const/4 v11, 0x2

    new-array v7, v11, [Ljava/lang/Class;

    const/4 v12, 0x0

    sget-object v11, Lorg/apache/log4j/helpers/OptionConverter;->class$java$lang$String:Ljava/lang/Class;

    if-nez v11, :cond_4

    const-string v11, "java.lang.String"

    invoke-static {v11}, Lorg/apache/log4j/helpers/OptionConverter;->class$(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v11

    sput-object v11, Lorg/apache/log4j/helpers/OptionConverter;->class$java$lang$String:Ljava/lang/Class;

    :goto_1
    aput-object v11, v7, v12

    const/4 v12, 0x1

    sget-object v11, Lorg/apache/log4j/helpers/OptionConverter;->class$org$apache$log4j$Level:Ljava/lang/Class;

    if-nez v11, :cond_5

    const-string v11, "org.apache.log4j.Level"

    invoke-static {v11}, Lorg/apache/log4j/helpers/OptionConverter;->class$(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v11

    sput-object v11, Lorg/apache/log4j/helpers/OptionConverter;->class$org$apache$log4j$Level:Ljava/lang/Class;

    :goto_2
    aput-object v11, v7, v12

    .line 222
    .local v7, "paramTypes":[Ljava/lang/Class;
    const-string v11, "toLevel"

    invoke-virtual {v2, v11, v7}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v10

    .line 226
    .local v10, "toLevelMethod":Ljava/lang/reflect/Method;
    const/4 v11, 0x2

    new-array v8, v11, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object v5, v8, v11

    const/4 v11, 0x1

    aput-object p1, v8, v11

    .line 227
    .local v8, "params":[Ljava/lang/Object;
    const/4 v11, 0x0

    invoke-virtual {v10, v11, v8}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .line 229
    .local v6, "o":Ljava/lang/Object;
    move-object v0, v6

    check-cast v0, Lorg/apache/log4j/Level;

    move-object v9, v0

    .end local v2    # "customLevel":Ljava/lang/Class;
    .end local v6    # "o":Ljava/lang/Object;
    .end local v7    # "paramTypes":[Ljava/lang/Class;
    .end local v8    # "params":[Ljava/lang/Object;
    .end local v10    # "toLevelMethod":Ljava/lang/reflect/Method;
    :goto_3
    move-object p1, v9

    .line 252
    goto/16 :goto_0

    .line 219
    .restart local v2    # "customLevel":Ljava/lang/Class;
    :cond_4
    sget-object v11, Lorg/apache/log4j/helpers/OptionConverter;->class$java$lang$String:Ljava/lang/Class;

    goto :goto_1

    :cond_5
    sget-object v11, Lorg/apache/log4j/helpers/OptionConverter;->class$org$apache$log4j$Level:Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_5

    goto :goto_2

    .line 230
    .end local v2    # "customLevel":Ljava/lang/Class;
    :catch_0
    move-exception v3

    .line 231
    .local v3, "e":Ljava/lang/ClassNotFoundException;
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    const-string v12, "custom level class ["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, "] not found."

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lorg/apache/log4j/helpers/LogLog;->warn(Ljava/lang/String;)V

    goto :goto_3

    .line 232
    .end local v3    # "e":Ljava/lang/ClassNotFoundException;
    :catch_1
    move-exception v3

    .line 233
    .local v3, "e":Ljava/lang/NoSuchMethodException;
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    const-string v12, "custom level class ["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, "]"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, " does not have a class function toLevel(String, Level)"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11, v3}, Lorg/apache/log4j/helpers/LogLog;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3

    .line 235
    .end local v3    # "e":Ljava/lang/NoSuchMethodException;
    :catch_2
    move-exception v3

    .line 236
    .local v3, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v3}, Ljava/lang/reflect/InvocationTargetException;->getTargetException()Ljava/lang/Throwable;

    move-result-object v11

    instance-of v11, v11, Ljava/lang/InterruptedException;

    if-nez v11, :cond_6

    invoke-virtual {v3}, Ljava/lang/reflect/InvocationTargetException;->getTargetException()Ljava/lang/Throwable;

    move-result-object v11

    instance-of v11, v11, Ljava/io/InterruptedIOException;

    if-eqz v11, :cond_7

    .line 238
    :cond_6
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Thread;->interrupt()V

    .line 240
    :cond_7
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    const-string v12, "custom level class ["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, "]"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, " could not be instantiated"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11, v3}, Lorg/apache/log4j/helpers/LogLog;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_3

    .line 242
    .end local v3    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_3
    move-exception v3

    .line 243
    .local v3, "e":Ljava/lang/ClassCastException;
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    const-string v12, "class ["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, "] is not a subclass of org.apache.log4j.Level"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11, v3}, Lorg/apache/log4j/helpers/LogLog;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_3

    .line 245
    .end local v3    # "e":Ljava/lang/ClassCastException;
    :catch_4
    move-exception v3

    .line 246
    .local v3, "e":Ljava/lang/IllegalAccessException;
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    const-string v12, "class ["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, "] cannot be instantiated due to access restrictions"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11, v3}, Lorg/apache/log4j/helpers/LogLog;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_3

    .line 248
    .end local v3    # "e":Ljava/lang/IllegalAccessException;
    :catch_5
    move-exception v3

    .line 249
    .local v3, "e":Ljava/lang/RuntimeException;
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    const-string v12, "class ["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, "], level ["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    const-string v12, "] conversion failed."

    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11, v3}, Lorg/apache/log4j/helpers/LogLog;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_3
.end method
