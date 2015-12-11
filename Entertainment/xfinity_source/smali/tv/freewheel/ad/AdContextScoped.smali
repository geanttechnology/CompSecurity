.class public Ltv/freewheel/ad/AdContextScoped;
.super Ljava/lang/Object;
.source "AdContextScoped.java"


# instance fields
.field protected context:Ltv/freewheel/ad/AdContext;

.field protected logger:Ltv/freewheel/utils/Logger;


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/AdContext;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/ad/AdContext;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    const/4 v0, 0x1

    invoke-static {p0, v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;Z)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/AdContextScoped;->logger:Ltv/freewheel/utils/Logger;

    .line 14
    iput-object p1, p0, Ltv/freewheel/ad/AdContextScoped;->context:Ltv/freewheel/ad/AdContext;

    .line 15
    return-void
.end method

.method public static getTextNodeValue(Lorg/w3c/dom/Node;)Ljava/lang/String;
    .locals 5
    .param p0, "node"    # Lorg/w3c/dom/Node;

    .prologue
    .line 61
    invoke-interface {p0}, Lorg/w3c/dom/Node;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v2

    .line 62
    .local v2, "nList":Lorg/w3c/dom/NodeList;
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_0
    invoke-interface {v2}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 63
    invoke-interface {v2, v1}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v3

    invoke-interface {v3}, Lorg/w3c/dom/Node;->getNodeValue()Ljava/lang/String;

    move-result-object v0

    .line 64
    .local v0, "c":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 68
    .end local v0    # "c":Ljava/lang/String;
    :goto_1
    return-object v0

    .line 62
    .restart local v0    # "c":Ljava/lang/String;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 68
    .end local v0    # "c":Ljava/lang/String;
    :cond_1
    const-string v0, ""

    goto :goto_1
.end method

.method public static tryParseBoolean(Ljava/lang/String;Z)Z
    .locals 1
    .param p0, "value"    # Ljava/lang/String;
    .param p1, "alternateValue"    # Z

    .prologue
    .line 54
    if-eqz p0, :cond_0

    const-string v0, ""

    if-ne p0, v0, :cond_1

    .line 57
    .end local p1    # "alternateValue":Z
    :cond_0
    :goto_0
    return p1

    .restart local p1    # "alternateValue":Z
    :cond_1
    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result p1

    goto :goto_0
.end method

.method public static tryParseDouble(Ljava/lang/String;)D
    .locals 2
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 72
    const-wide/16 v0, 0x0

    invoke-static {p0, v0, v1}, Ltv/freewheel/ad/AdContextScoped;->tryParseDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public static tryParseDouble(Ljava/lang/String;D)D
    .locals 5
    .param p0, "value"    # Ljava/lang/String;
    .param p1, "alternateValue"    # D

    .prologue
    .line 39
    if-eqz p0, :cond_0

    const-string v3, ""

    if-ne p0, v3, :cond_1

    :cond_0
    move-wide v0, p1

    .line 50
    :goto_0
    return-wide v0

    .line 45
    :cond_1
    :try_start_0
    invoke-static {p0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v0

    .local v0, "doubleValue":D
    goto :goto_0

    .line 46
    .end local v0    # "doubleValue":D
    :catch_0
    move-exception v2

    .line 47
    .local v2, "e":Ljava/lang/NumberFormatException;
    move-wide v0, p1

    .restart local v0    # "doubleValue":D
    goto :goto_0
.end method

.method public static tryParseInt(Ljava/lang/String;)I
    .locals 1
    .param p0, "value"    # Ljava/lang/String;

    .prologue
    .line 34
    const/4 v0, 0x0

    invoke-static {p0, v0}, Ltv/freewheel/ad/AdContextScoped;->tryParseInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static tryParseInt(Ljava/lang/String;I)I
    .locals 3
    .param p0, "value"    # Ljava/lang/String;
    .param p1, "alternateIntValue"    # I

    .prologue
    .line 19
    if-eqz p0, :cond_0

    const-string v2, ""

    if-ne p0, v2, :cond_1

    :cond_0
    move v1, p1

    .line 30
    :goto_0
    return v1

    .line 25
    :cond_1
    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .local v1, "intValue":I
    goto :goto_0

    .line 26
    .end local v1    # "intValue":I
    :catch_0
    move-exception v0

    .line 27
    .local v0, "e":Ljava/lang/NumberFormatException;
    move v1, p1

    .restart local v1    # "intValue":I
    goto :goto_0
.end method


# virtual methods
.method public getAdContext()Ltv/freewheel/ad/AdContext;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Ltv/freewheel/ad/AdContextScoped;->context:Ltv/freewheel/ad/AdContext;

    return-object v0
.end method

.method public getAdRequest()Ltv/freewheel/ad/AdRequest;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Ltv/freewheel/ad/AdContextScoped;->context:Ltv/freewheel/ad/AdContext;

    iget-object v0, v0, Ltv/freewheel/ad/AdContext;->adRequest:Ltv/freewheel/ad/AdRequest;

    return-object v0
.end method

.method public getAdResponse()Ltv/freewheel/ad/AdResponse;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Ltv/freewheel/ad/AdContextScoped;->context:Ltv/freewheel/ad/AdContext;

    iget-object v0, v0, Ltv/freewheel/ad/AdContext;->adResponse:Ltv/freewheel/ad/AdResponse;

    return-object v0
.end method
