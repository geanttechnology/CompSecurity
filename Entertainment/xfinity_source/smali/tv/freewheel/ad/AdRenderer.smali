.class public Ltv/freewheel/ad/AdRenderer;
.super Ltv/freewheel/ad/ParametersHolder;
.source "AdRenderer.java"


# static fields
.field private static RENDERERS:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<+",
            "Ltv/freewheel/renderers/interfaces/IRenderer;",
            ">;>;"
        }
    .end annotation
.end field

.field private static logger:Ltv/freewheel/utils/Logger;


# instance fields
.field protected adUnit:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected contentType:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected creativeApi:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public name:Ljava/lang/String;

.field private rendererClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field protected slotType:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected soAdUnit:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public url:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 18
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    sput-object v0, Ltv/freewheel/ad/AdRenderer;->RENDERERS:Ljava/util/Map;

    .line 33
    const-string v0, "AdRenderer"

    invoke-static {v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/String;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    sput-object v0, Ltv/freewheel/ad/AdRenderer;->logger:Ltv/freewheel/utils/Logger;

    .line 36
    sget-object v0, Ltv/freewheel/ad/AdRenderer;->RENDERERS:Ljava/util/Map;

    const-string v1, "null/null"

    const-class v2, Ltv/freewheel/renderers/nullnull/NullAdRenderer;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    sget-object v0, Ltv/freewheel/ad/AdRenderer;->RENDERERS:Ljava/util/Map;

    const-string v1, "test/ad"

    const-class v2, Ltv/freewheel/renderers/test/TestRenderer;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    sget-object v0, Ltv/freewheel/ad/AdRenderer;->RENDERERS:Ljava/util/Map;

    const-string v1, "VideoRenderer"

    const-class v2, Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 39
    sget-object v0, Ltv/freewheel/ad/AdRenderer;->RENDERERS:Ljava/util/Map;

    const-string v1, "HTMLRenderer"

    const-class v2, Ltv/freewheel/renderers/html/HTMLRenderer;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    sget-object v0, Ltv/freewheel/ad/AdRenderer;->RENDERERS:Ljava/util/Map;

    const-string v1, "VastTranslator"

    const-class v2, Ltv/freewheel/renderers/vast/VastTranslator;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    return-void
.end method

.method public constructor <init>(Ltv/freewheel/ad/AdContext;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/ad/AdContext;

    .prologue
    .line 105
    invoke-direct {p0, p1}, Ltv/freewheel/ad/ParametersHolder;-><init>(Ltv/freewheel/ad/AdContext;)V

    .line 30
    const/4 v0, 0x0

    iput-object v0, p0, Ltv/freewheel/ad/AdRenderer;->rendererClass:Ljava/lang/Class;

    .line 106
    return-void
.end method

.method public static getRenderer(Ltv/freewheel/ad/AdRenderer;)Ltv/freewheel/renderers/interfaces/IRenderer;
    .locals 9
    .param p0, "rendererDescription"    # Ltv/freewheel/ad/AdRenderer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InstantiationException;,
            Ljava/lang/IllegalAccessException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 48
    sget-object v6, Ltv/freewheel/ad/AdRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "getRenderer for url "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 49
    iget-object v6, p0, Ltv/freewheel/ad/AdRenderer;->rendererClass:Ljava/lang/Class;

    if-eqz v6, :cond_0

    .line 50
    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->rendererClass:Ljava/lang/Class;

    invoke-virtual {v5}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ltv/freewheel/renderers/interfaces/IRenderer;

    .line 101
    :goto_0
    return-object v5

    .line 53
    :cond_0
    iget-object v4, p0, Ltv/freewheel/ad/AdRenderer;->name:Ljava/lang/String;

    .line 54
    .local v4, "name":Ljava/lang/String;
    const/4 v0, 0x0

    .line 56
    .local v0, "className":Ljava/lang/String;
    iget-object v6, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    if-eqz v6, :cond_2

    .line 57
    iget-object v6, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    const-string v7, "http"

    invoke-virtual {v6, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    iget-object v6, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    const-string v7, "https"

    invoke-virtual {v6, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 59
    :cond_1
    iget-object v6, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    const/16 v7, 0x2f

    invoke-virtual {v6, v7}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v3

    .line 60
    .local v3, "idx":I
    if-ltz v3, :cond_2

    .line 61
    iget-object v6, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    add-int/lit8 v7, v3, 0x1

    invoke-virtual {v6, v7}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    .line 63
    const-string v6, ".fpk"

    invoke-virtual {v4, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    .line 64
    if-ltz v3, :cond_2

    .line 65
    const/4 v6, 0x0

    invoke-virtual {v4, v6, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 79
    .end local v3    # "idx":I
    :cond_2
    :goto_1
    if-nez v4, :cond_5

    .line 80
    sget-object v6, Ltv/freewheel/ad/AdRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unknown renderer URL "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", should be the format class://com.example.myClassName"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto :goto_0

    .line 68
    :cond_3
    iget-object v6, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    const-string v7, "class://"

    invoke-virtual {v6, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 69
    iget-object v6, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 70
    const/16 v6, 0x2e

    invoke-virtual {v0, v6}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v3

    .line 71
    .restart local v3    # "idx":I
    if-ltz v3, :cond_4

    .line 72
    add-int/lit8 v6, v3, 0x1

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 74
    :cond_4
    move-object v4, v0

    goto :goto_1

    .line 85
    .end local v3    # "idx":I
    :cond_5
    sget-object v6, Ltv/freewheel/ad/AdRenderer;->RENDERERS:Ljava/util/Map;

    invoke-interface {v6, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Class;

    .line 86
    .local v1, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-nez v1, :cond_7

    .line 87
    if-nez v0, :cond_6

    .line 88
    sget-object v6, Ltv/freewheel/ad/AdRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Can not find registered renderer class for name "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 93
    :cond_6
    :try_start_0
    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 100
    :cond_7
    iput-object v1, p0, Ltv/freewheel/ad/AdRenderer;->rendererClass:Ljava/lang/Class;

    .line 101
    invoke-virtual {v1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ltv/freewheel/renderers/interfaces/IRenderer;

    goto/16 :goto_0

    .line 94
    :catch_0
    move-exception v2

    .line 95
    .local v2, "e":Ljava/lang/ClassNotFoundException;
    sget-object v6, Ltv/freewheel/ad/AdRenderer;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Failed to load class "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->error(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private parseFromCommaString(Ljava/lang/String;)Ljava/util/HashSet;
    .locals 4
    .param p1, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 142
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 143
    .local v1, "set":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 144
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 145
    .local v0, "list":[Ljava/lang/String;
    invoke-static {v1, v0}, Ljava/util/Collections;->addAll(Ljava/util/Collection;[Ljava/lang/Object;)Z

    .line 147
    .end local v0    # "list":[Ljava/lang/String;
    :cond_0
    return-object v1
.end method


# virtual methods
.method public isTranslator()Z
    .locals 2

    .prologue
    .line 166
    iget-object v0, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "translator"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public match(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 7
    .param p1, "adUnit"    # Ljava/lang/String;
    .param p2, "soAdUnit"    # Ljava/lang/String;
    .param p3, "contentType"    # Ljava/lang/String;
    .param p4, "slotType"    # Ljava/lang/String;
    .param p5, "creativeAPI"    # Ljava/lang/String;
    .param p6, "wrapperType"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 153
    if-eqz p6, :cond_0

    const-string v5, ""

    invoke-virtual {p6, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    :cond_0
    move v1, v3

    .line 154
    .local v1, "noWrapperType":Z
    :goto_0
    if-eqz v1, :cond_7

    move-object v0, p3

    .line 156
    .local v0, "adType":Ljava/lang/String;
    :goto_1
    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->adUnit:Ljava/util/HashSet;

    invoke-virtual {v5}, Ljava/util/HashSet;->size()I

    move-result v5

    if-eqz v5, :cond_1

    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->adUnit:Ljava/util/HashSet;

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    :cond_1
    move v2, v3

    .line 157
    .local v2, "ret":Z
    :goto_2
    if-eqz v2, :cond_9

    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->soAdUnit:Ljava/util/HashSet;

    invoke-virtual {v5}, Ljava/util/HashSet;->size()I

    move-result v5

    if-eqz v5, :cond_2

    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->soAdUnit:Ljava/util/HashSet;

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_9

    :cond_2
    move v2, v3

    .line 158
    :goto_3
    if-eqz v2, :cond_a

    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->contentType:Ljava/util/HashSet;

    invoke-virtual {v5}, Ljava/util/HashSet;->size()I

    move-result v5

    if-eqz v5, :cond_3

    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->contentType:Ljava/util/HashSet;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_a

    :cond_3
    move v2, v3

    .line 159
    :goto_4
    if-eqz v2, :cond_b

    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->slotType:Ljava/util/HashSet;

    invoke-virtual {v5}, Ljava/util/HashSet;->size()I

    move-result v5

    if-eqz v5, :cond_4

    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->slotType:Ljava/util/HashSet;

    invoke-virtual {p4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_b

    :cond_4
    move v2, v3

    .line 160
    :goto_5
    if-eqz v2, :cond_c

    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->creativeApi:Ljava/util/HashSet;

    invoke-virtual {v5}, Ljava/util/HashSet;->size()I

    move-result v5

    if-eqz v5, :cond_5

    iget-object v5, p0, Ltv/freewheel/ad/AdRenderer;->creativeApi:Ljava/util/HashSet;

    invoke-virtual {p5}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_c

    :cond_5
    move v2, v3

    .line 162
    :goto_6
    return v2

    .end local v0    # "adType":Ljava/lang/String;
    .end local v1    # "noWrapperType":Z
    .end local v2    # "ret":Z
    :cond_6
    move v1, v4

    .line 153
    goto :goto_0

    .restart local v1    # "noWrapperType":Z
    :cond_7
    move-object v0, p6

    .line 154
    goto :goto_1

    .restart local v0    # "adType":Ljava/lang/String;
    :cond_8
    move v2, v4

    .line 156
    goto :goto_2

    .restart local v2    # "ret":Z
    :cond_9
    move v2, v4

    .line 157
    goto :goto_3

    :cond_a
    move v2, v4

    .line 158
    goto :goto_4

    :cond_b
    move v2, v4

    .line 159
    goto :goto_5

    :cond_c
    move v2, v4

    .line 160
    goto :goto_6
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 6
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 125
    const-string v5, "contentType"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 126
    .local v1, "contentTypeStr":Ljava/lang/String;
    invoke-direct {p0, v1}, Ltv/freewheel/ad/AdRenderer;->parseFromCommaString(Ljava/lang/String;)Ljava/util/HashSet;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/ad/AdRenderer;->contentType:Ljava/util/HashSet;

    .line 127
    const-string v5, "slotType"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 128
    .local v3, "slotTypeStr":Ljava/lang/String;
    invoke-direct {p0, v3}, Ltv/freewheel/ad/AdRenderer;->parseFromCommaString(Ljava/lang/String;)Ljava/util/HashSet;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/ad/AdRenderer;->slotType:Ljava/util/HashSet;

    .line 129
    const-string v5, "adUnit"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 130
    .local v0, "adUnitStr":Ljava/lang/String;
    invoke-direct {p0, v0}, Ltv/freewheel/ad/AdRenderer;->parseFromCommaString(Ljava/lang/String;)Ljava/util/HashSet;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/ad/AdRenderer;->adUnit:Ljava/util/HashSet;

    .line 131
    const-string v5, "creativeApi"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 132
    .local v2, "creativeApiStr":Ljava/lang/String;
    invoke-direct {p0, v2}, Ltv/freewheel/ad/AdRenderer;->parseFromCommaString(Ljava/lang/String;)Ljava/util/HashSet;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/ad/AdRenderer;->creativeApi:Ljava/util/HashSet;

    .line 133
    const-string v5, "soAdUnit"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 134
    .local v4, "soAdUnitStr":Ljava/lang/String;
    invoke-direct {p0, v4}, Ltv/freewheel/ad/AdRenderer;->parseFromCommaString(Ljava/lang/String;)Ljava/util/HashSet;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/ad/AdRenderer;->soAdUnit:Ljava/util/HashSet;

    .line 135
    const-string v5, "url"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/ad/AdRenderer;->url:Ljava/lang/String;

    .line 136
    const-string v5, "name"

    invoke-interface {p1, v5}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ltv/freewheel/ad/AdRenderer;->name:Ljava/lang/String;

    .line 138
    invoke-virtual {p0, p1}, Ltv/freewheel/ad/AdRenderer;->parseRendererParameters(Lorg/w3c/dom/Element;)V

    .line 139
    return-void
.end method
