.class Ltv/freewheel/renderers/html/Parameters;
.super Ljava/lang/Object;
.source "Parameters.java"


# instance fields
.field bootstrap:Ljava/lang/String;

.field logger:Ltv/freewheel/utils/Logger;

.field marginHeight:Ljava/lang/Integer;

.field marginWidth:Ljava/lang/Integer;

.field placementType:Ljava/lang/String;

.field primaryAnchor:Ljava/lang/String;

.field shouldBackgroundTransparent:Ljava/lang/Boolean;

.field shouldEndAfterDuration:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>(Ltv/freewheel/renderers/interfaces/IRendererContext;)V
    .locals 7
    .param p1, "context"    # Ltv/freewheel/renderers/interfaces/IRendererContext;

    .prologue
    const/4 v6, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x0

    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->logger:Ltv/freewheel/utils/Logger;

    .line 22
    const/4 v1, 0x0

    .line 23
    .local v1, "pval":Ljava/lang/Object;
    const-string v3, "renderer.html.placementType"

    invoke-interface {p1, v3}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 24
    if-eqz v1, :cond_4

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_0
    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->placementType:Ljava/lang/String;

    .line 26
    const-string v3, "renderer.html.primaryAnchor"

    invoke-interface {p1, v3}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 27
    if-nez v1, :cond_5

    .line 28
    const-string v3, "bc"

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->primaryAnchor:Ljava/lang/String;

    .line 33
    :goto_1
    const-string v3, "renderer.html.marginWidth"

    invoke-interface {p1, v3}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 34
    if-nez v1, :cond_6

    .line 35
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->marginWidth:Ljava/lang/Integer;

    .line 43
    :goto_2
    const-string v3, "renderer.html.marginHeight"

    invoke-interface {p1, v3}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 44
    if-nez v1, :cond_7

    .line 45
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->marginHeight:Ljava/lang/Integer;

    .line 54
    :goto_3
    const-string v3, "renderer.html.bootstrap"

    invoke-interface {p1, v3}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 55
    if-eqz v1, :cond_8

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_4
    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->bootstrap:Ljava/lang/String;

    .line 57
    const-string v3, "renderer.html.shouldEndAfterDuration"

    invoke-interface {p1, v3}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 58
    iput-object v4, p0, Ltv/freewheel/renderers/html/Parameters;->shouldEndAfterDuration:Ljava/lang/Boolean;

    .line 59
    if-eqz v1, :cond_1

    .line 60
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 61
    .local v2, "pvalstr":Ljava/lang/String;
    const-string v3, "true"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string v3, "on"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string v3, "yes"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_9

    .line 62
    :cond_0
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->shouldEndAfterDuration:Ljava/lang/Boolean;

    .line 68
    .end local v2    # "pvalstr":Ljava/lang/String;
    :cond_1
    :goto_5
    const-string v3, "renderer.html.isBackgroundTransparent"

    invoke-interface {p1, v3}, Ltv/freewheel/renderers/interfaces/IRendererContext;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 69
    iput-object v4, p0, Ltv/freewheel/renderers/html/Parameters;->shouldBackgroundTransparent:Ljava/lang/Boolean;

    .line 70
    if-eqz v1, :cond_3

    .line 71
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 72
    .restart local v2    # "pvalstr":Ljava/lang/String;
    const-string v3, "true"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string v3, "on"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string v3, "yes"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string v3, "1"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_b

    .line 73
    :cond_2
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->shouldBackgroundTransparent:Ljava/lang/Boolean;

    .line 78
    .end local v2    # "pvalstr":Ljava/lang/String;
    :cond_3
    :goto_6
    iget-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {p0}, Ltv/freewheel/renderers/html/Parameters;->toJSONString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 79
    return-void

    :cond_4
    move-object v3, v4

    .line 24
    goto/16 :goto_0

    .line 30
    :cond_5
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->primaryAnchor:Ljava/lang/String;

    goto/16 :goto_1

    .line 38
    :cond_6
    :try_start_0
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->marginWidth:Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_2

    .line 39
    :catch_0
    move-exception v0

    .line 40
    .local v0, "e":Ljava/lang/NumberFormatException;
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->marginWidth:Ljava/lang/Integer;

    goto/16 :goto_2

    .line 48
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    :cond_7
    :try_start_1
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->marginHeight:Ljava/lang/Integer;
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_3

    .line 49
    :catch_1
    move-exception v0

    .line 50
    .restart local v0    # "e":Ljava/lang/NumberFormatException;
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->marginHeight:Ljava/lang/Integer;

    goto/16 :goto_3

    .end local v0    # "e":Ljava/lang/NumberFormatException;
    :cond_8
    move-object v3, v4

    .line 55
    goto/16 :goto_4

    .line 63
    .restart local v2    # "pvalstr":Ljava/lang/String;
    :cond_9
    const-string v3, "false"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_a

    const-string v3, "off"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_a

    const-string v3, "no"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 64
    :cond_a
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->shouldEndAfterDuration:Ljava/lang/Boolean;

    goto/16 :goto_5

    .line 74
    :cond_b
    const-string v3, "false"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_c

    const-string v3, "off"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_c

    const-string v3, "no"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_c

    const-string v3, "0"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 75
    :cond_c
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Ltv/freewheel/renderers/html/Parameters;->shouldBackgroundTransparent:Ljava/lang/Boolean;

    goto/16 :goto_6
.end method


# virtual methods
.method public toJSONString()Ljava/lang/String;
    .locals 7

    .prologue
    .line 82
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 83
    .local v3, "json":Lorg/json/JSONObject;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    const-class v5, Ltv/freewheel/renderers/html/Parameters;

    invoke-virtual {v5}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v5

    array-length v5, v5

    if-ge v2, v5, :cond_3

    .line 84
    const-class v5, Ltv/freewheel/renderers/html/Parameters;

    invoke-virtual {v5}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v5

    aget-object v1, v5, v2

    .line 85
    .local v1, "field":Ljava/lang/reflect/Field;
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getModifiers()I

    move-result v5

    invoke-static {v5}, Ljava/lang/reflect/Modifier;->isStatic(I)Z

    move-result v5

    if-nez v5, :cond_2

    .line 87
    :try_start_0
    invoke-virtual {v1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 88
    .local v4, "value":Ljava/lang/Object;
    instance-of v5, v4, Ljava/util/Calendar;

    if-eqz v5, :cond_0

    .line 89
    check-cast v4, Ljava/util/Calendar;

    .end local v4    # "value":Ljava/lang/Object;
    invoke-virtual {v4}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Date;->toString()Ljava/lang/String;

    move-result-object v4

    .line 91
    :cond_0
    instance-of v5, v4, Ljava/lang/Integer;

    if-eqz v5, :cond_1

    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "Color"

    invoke-virtual {v5, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 92
    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v4

    .line 94
    :cond_1
    invoke-virtual {v1}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    :cond_2
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 95
    :catch_0
    move-exception v0

    .line 96
    .local v0, "e":Ljava/lang/Exception;
    iget-object v5, p0, Ltv/freewheel/renderers/html/Parameters;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_1

    .line 100
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "field":Ljava/lang/reflect/Field;
    :cond_3
    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v5

    return-object v5
.end method
