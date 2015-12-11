.class public Ltv/freewheel/hybrid/extension/ParamParser;
.super Ljava/lang/Object;
.source "ParamParser.java"


# instance fields
.field private context:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

.field private logger:Ltv/freewheel/hybrid/utils/Logger;

.field private paramNamespace:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/interfaces/IAdContext;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/interfaces/IAdContext;
    .param p2, "paramNamespace"    # Ljava/lang/String;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/ParamParser;->context:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    .line 23
    iput-object p2, p0, Ltv/freewheel/hybrid/extension/ParamParser;->paramNamespace:Ljava/lang/String;

    .line 24
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/hybrid/extension/ParamParser;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 25
    return-void
.end method

.method private getNamespacedParam(Ljava/lang/String;)Ljava/lang/Object;
    .locals 4
    .param p1, "paramNameWithoutNamespace"    # Ljava/lang/String;

    .prologue
    .line 216
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/ParamParser;->context:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Ltv/freewheel/hybrid/extension/ParamParser;->paramNamespace:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 217
    .local v0, "value":Ljava/lang/Object;
    if-eqz v0, :cond_0

    .line 218
    .end local v0    # "value":Ljava/lang/Object;
    :goto_0
    return-object v0

    .restart local v0    # "value":Ljava/lang/Object;
    :cond_0
    iget-object v1, p0, Ltv/freewheel/hybrid/extension/ParamParser;->context:Ltv/freewheel/hybrid/ad/interfaces/IAdContext;

    invoke-interface {v1, p1}, Ltv/freewheel/hybrid/ad/interfaces/IAdContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method private getNamespacedParamStr(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "paramNameWithoutNamespace"    # Ljava/lang/String;

    .prologue
    .line 212
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/extension/ParamParser;->getNamespacedParam(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public parseBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 2
    .param p1, "paramName"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/Boolean;

    .prologue
    .line 44
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/extension/ParamParser;->getNamespacedParamStr(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 45
    .local v0, "str":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 46
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 47
    const-string v1, "true"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "on"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "yes"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 48
    :cond_0
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p2

    .line 54
    .end local p2    # "defaultValue":Ljava/lang/Boolean;
    :cond_1
    :goto_0
    return-object p2

    .line 49
    .restart local p2    # "defaultValue":Ljava/lang/Boolean;
    :cond_2
    const-string v1, "false"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "off"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "no"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 51
    :cond_3
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object p2

    goto :goto_0
.end method
