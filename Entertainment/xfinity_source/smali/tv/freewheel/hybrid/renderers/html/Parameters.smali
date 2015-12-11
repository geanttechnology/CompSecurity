.class Ltv/freewheel/hybrid/renderers/html/Parameters;
.super Ljava/lang/Object;
.source "Parameters.java"


# instance fields
.field bootstrap:Ljava/lang/String;

.field logger:Ltv/freewheel/hybrid/utils/Logger;

.field marginHeight:Ljava/lang/Integer;

.field marginWidth:Ljava/lang/Integer;

.field placementType:Ljava/lang/String;

.field primaryAnchor:Ljava/lang/String;

.field shouldBackgroundTransparent:Ljava/lang/Boolean;

.field shouldEndAfterDuration:Ljava/lang/Boolean;

.field shouldUseDip:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V
    .locals 6
    .param p1, "context"    # Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 23
    const-string v2, "renderer.html.placementType"

    invoke-interface {p1, v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->placementType:Ljava/lang/String;

    .line 24
    const-string v2, "renderer.html.primaryAnchor"

    invoke-interface {p1, v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->primaryAnchor:Ljava/lang/String;

    .line 25
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->primaryAnchor:Ljava/lang/String;

    if-nez v2, :cond_0

    .line 26
    const-string v2, "bc"

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->primaryAnchor:Ljava/lang/String;

    .line 28
    :cond_0
    const/4 v1, 0x0

    .line 29
    .local v1, "pval":Ljava/lang/String;
    const-string v2, "renderer.html.marginWidth"

    invoke-interface {p1, v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "pval":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 30
    .restart local v1    # "pval":Ljava/lang/String;
    if-nez v1, :cond_7

    .line 31
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->marginWidth:Ljava/lang/Integer;

    .line 39
    :goto_0
    const-string v2, "renderer.html.marginHeight"

    invoke-interface {p1, v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "pval":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 40
    .restart local v1    # "pval":Ljava/lang/String;
    if-nez v1, :cond_8

    .line 41
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->marginHeight:Ljava/lang/Integer;

    .line 50
    :goto_1
    const-string v2, "renderer.html.bootstrap"

    invoke-interface {p1, v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->bootstrap:Ljava/lang/String;

    .line 52
    const-string v2, "renderer.html.shouldEndAfterDuration"

    invoke-interface {p1, v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "pval":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 53
    .restart local v1    # "pval":Ljava/lang/String;
    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldEndAfterDuration:Ljava/lang/Boolean;

    .line 54
    if-eqz v1, :cond_2

    .line 55
    const-string v2, "true"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    const-string v2, "on"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    const-string v2, "yes"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 56
    :cond_1
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldEndAfterDuration:Ljava/lang/Boolean;

    .line 61
    :cond_2
    :goto_2
    const-string v2, "renderer.html.isBackgroundTransparent"

    invoke-interface {p1, v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "pval":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 62
    .restart local v1    # "pval":Ljava/lang/String;
    iput-object v5, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldBackgroundTransparent:Ljava/lang/Boolean;

    .line 63
    if-eqz v1, :cond_4

    .line 64
    const-string v2, "true"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    const-string v2, "on"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    const-string v2, "yes"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3

    const-string v2, "1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 65
    :cond_3
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldBackgroundTransparent:Ljava/lang/Boolean;

    .line 70
    :cond_4
    :goto_3
    const-string v2, "renderer.html.shouldUseDip"

    invoke-interface {p1, v2}, Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "pval":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 71
    .restart local v1    # "pval":Ljava/lang/String;
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldUseDip:Ljava/lang/Boolean;

    .line 72
    if-eqz v1, :cond_6

    .line 73
    const-string v2, "true"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    const-string v2, "on"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    const-string v2, "yes"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_5

    const-string v2, "1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 74
    :cond_5
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldUseDip:Ljava/lang/Boolean;

    .line 77
    :cond_6
    iget-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->logger:Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {p0}, Ltv/freewheel/hybrid/renderers/html/Parameters;->toJSONString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 78
    return-void

    .line 34
    :cond_7
    :try_start_0
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->marginWidth:Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 35
    :catch_0
    move-exception v0

    .line 36
    .local v0, "e":Ljava/lang/NumberFormatException;
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->marginWidth:Ljava/lang/Integer;

    goto/16 :goto_0

    .line 44
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    :cond_8
    :try_start_1
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->marginHeight:Ljava/lang/Integer;
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_1

    .line 45
    :catch_1
    move-exception v0

    .line 46
    .restart local v0    # "e":Ljava/lang/NumberFormatException;
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->marginHeight:Ljava/lang/Integer;

    goto/16 :goto_1

    .line 57
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    :cond_9
    const-string v2, "false"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_a

    const-string v2, "off"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_a

    const-string v2, "no"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 58
    :cond_a
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldEndAfterDuration:Ljava/lang/Boolean;

    goto/16 :goto_2

    .line 66
    :cond_b
    const-string v2, "false"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_c

    const-string v2, "off"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_c

    const-string v2, "no"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_c

    const-string v2, "0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 67
    :cond_c
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->shouldBackgroundTransparent:Ljava/lang/Boolean;

    goto/16 :goto_3
.end method


# virtual methods
.method public toJSONString()Ljava/lang/String;
    .locals 7

    .prologue
    .line 81
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 82
    .local v3, "json":Lorg/json/JSONObject;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    const-class v5, Ltv/freewheel/hybrid/renderers/html/Parameters;

    invoke-virtual {v5}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v5

    array-length v5, v5

    if-ge v2, v5, :cond_3

    .line 83
    const-class v5, Ltv/freewheel/hybrid/renderers/html/Parameters;

    invoke-virtual {v5}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v5

    aget-object v1, v5, v2

    .line 84
    .local v1, "field":Ljava/lang/reflect/Field;
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getModifiers()I

    move-result v5

    invoke-static {v5}, Ljava/lang/reflect/Modifier;->isStatic(I)Z

    move-result v5

    if-nez v5, :cond_2

    .line 86
    :try_start_0
    invoke-virtual {v1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 87
    .local v4, "value":Ljava/lang/Object;
    instance-of v5, v4, Ljava/util/Calendar;

    if-eqz v5, :cond_0

    .line 88
    check-cast v4, Ljava/util/Calendar;

    .end local v4    # "value":Ljava/lang/Object;
    invoke-virtual {v4}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Date;->toString()Ljava/lang/String;

    move-result-object v4

    .line 90
    :cond_0
    instance-of v5, v4, Ljava/lang/Integer;

    if-eqz v5, :cond_1

    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "Color"

    invoke-virtual {v5, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 91
    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v4

    .line 93
    :cond_1
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    :cond_2
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 94
    :catch_0
    move-exception v0

    .line 95
    .local v0, "e":Ljava/lang/Exception;
    iget-object v5, p0, Ltv/freewheel/hybrid/renderers/html/Parameters;->logger:Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_1

    .line 99
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "field":Ljava/lang/reflect/Field;
    :cond_3
    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5
.end method
