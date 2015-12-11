.class public Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;
.super Ljava/lang/Object;
.source "StringUtils.java"


# direct methods
.method public static isBlank(Ljava/lang/String;)Z
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 58
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static parseBoolean(Ljava/lang/String;)Ljava/lang/Boolean;
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 41
    const/4 v0, 0x0

    invoke-static {p0, v0}, Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;->parseBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public static parseBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 1
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Ljava/lang/Boolean;

    .prologue
    .line 46
    :try_start_0
    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    .line 49
    .end local p1    # "defaultValue":Ljava/lang/Boolean;
    :goto_0
    return-object p1

    .line 48
    .restart local p1    # "defaultValue":Ljava/lang/Boolean;
    :catch_0
    move-exception v0

    .line 49
    .local v0, "e":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method

.method public static parseInt(Ljava/lang/String;)I
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 6
    const/4 v0, 0x0

    invoke-static {p0, v0}, Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;->parseInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static parseInt(Ljava/lang/String;I)I
    .locals 1
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "defaultValue"    # I

    .prologue
    .line 11
    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result p1

    .line 14
    .end local p1    # "defaultValue":I
    :goto_0
    return p1

    .line 13
    .restart local p1    # "defaultValue":I
    :catch_0
    move-exception v0

    .line 14
    .local v0, "e":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method

.method public static parseInteger(Ljava/lang/String;)Ljava/lang/Integer;
    .locals 1
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 28
    const/4 v0, 0x0

    invoke-static {p0, v0}, Ltv/freewheel/hybrid/renderers/vast/util/StringUtils;->parseInteger(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public static parseInteger(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 1
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "defaultValue"    # Ljava/lang/Integer;

    .prologue
    .line 20
    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    .line 23
    .end local p1    # "defaultValue":Ljava/lang/Integer;
    :goto_0
    return-object p1

    .line 22
    .restart local p1    # "defaultValue":Ljava/lang/Integer;
    :catch_0
    move-exception v0

    .line 23
    .local v0, "e":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method
