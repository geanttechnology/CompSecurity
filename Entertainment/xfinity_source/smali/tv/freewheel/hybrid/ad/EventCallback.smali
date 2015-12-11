.class public Ltv/freewheel/hybrid/ad/EventCallback;
.super Ltv/freewheel/hybrid/ad/AdContextScoped;
.source "EventCallback.java"


# static fields
.field public static final EVENT_TYPES:[Ljava/lang/String;

.field public static final SHORT_EVENT_TYPES:[Ljava/lang/String;

.field public static final VALID_ERROR_EVENT_NAMES:[Ljava/lang/String;

.field public static final VALID_IMPRESSION_EVENT_NAMES:[Ljava/lang/String;

.field public static final VALID_STANDARD_EVENT_NAMES:[Ljava/lang/String;


# instance fields
.field public name:Ljava/lang/String;

.field public showBrowser:Z

.field public trackingURLs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public type:Ljava/lang/String;

.field public url:Ljava/lang/String;

.field public usage:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 104
    new-array v0, v7, [Ljava/lang/String;

    const-string v1, "CLICK"

    aput-object v1, v0, v3

    const-string v1, "CLICKTRACKING"

    aput-object v1, v0, v4

    const-string v1, "IMPRESSION"

    aput-object v1, v0, v5

    const-string v1, "STANDARD"

    aput-object v1, v0, v6

    sput-object v0, Ltv/freewheel/hybrid/ad/EventCallback;->EVENT_TYPES:[Ljava/lang/String;

    .line 111
    new-array v0, v7, [Ljava/lang/String;

    const-string v1, "c"

    aput-object v1, v0, v3

    const-string v1, "c"

    aput-object v1, v0, v4

    const-string v1, "i"

    aput-object v1, v0, v5

    const-string v1, "s"

    aput-object v1, v0, v6

    sput-object v0, Ltv/freewheel/hybrid/ad/EventCallback;->SHORT_EVENT_TYPES:[Ljava/lang/String;

    .line 118
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "defaultImpression"

    aput-object v1, v0, v3

    const-string v1, "firstQuartile"

    aput-object v1, v0, v4

    const-string v1, "midPoint"

    aput-object v1, v0, v5

    const-string v1, "thirdQuartile"

    aput-object v1, v0, v6

    const-string v1, "complete"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "resellerNoAd"

    aput-object v2, v0, v1

    sput-object v0, Ltv/freewheel/hybrid/ad/EventCallback;->VALID_IMPRESSION_EVENT_NAMES:[Ljava/lang/String;

    .line 127
    const/16 v0, 0xa

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_pause"

    aput-object v1, v0, v3

    const-string v1, "_resume"

    aput-object v1, v0, v4

    const-string v1, "_rewind"

    aput-object v1, v0, v5

    const-string v1, "_mute"

    aput-object v1, v0, v6

    const-string v1, "_un-mute"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "_collapse"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "_expand"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "_minimize"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "_close"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "_accept-invitation"

    aput-object v2, v0, v1

    sput-object v0, Ltv/freewheel/hybrid/ad/EventCallback;->VALID_STANDARD_EVENT_NAMES:[Ljava/lang/String;

    .line 140
    const/16 v0, 0xc

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "_e_adinst-unavail"

    aput-object v1, v0, v3

    const-string v1, "_e_invalid-value"

    aput-object v1, v0, v4

    const-string v1, "_e_io"

    aput-object v1, v0, v5

    const-string v1, "_e_missing-param"

    aput-object v1, v0, v6

    const-string v1, "_e_no-ad"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "_e_no-renderer"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "_e_null-asset"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "_e_parse"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "_e_renderer-load"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "_e_timeout"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "_e_unknown"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, ""

    aput-object v2, v0, v1

    sput-object v0, Ltv/freewheel/hybrid/ad/EventCallback;->VALID_ERROR_EVENT_NAMES:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;)V
    .locals 1
    .param p1, "context"    # Ltv/freewheel/hybrid/ad/AdContext;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/AdContextScoped;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 15
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/EventCallback;->showBrowser:Z

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/EventCallback;->trackingURLs:Ljava/util/ArrayList;

    .line 21
    return-void
.end method

.method public static getEventTypeByName(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "eventName"    # Ljava/lang/String;

    .prologue
    const/4 v2, -0x1

    .line 83
    const-string v0, "CLICKTRACKING"

    .line 84
    .local v0, "eventType":Ljava/lang/String;
    sget-object v1, Ltv/freewheel/hybrid/ad/EventCallback;->VALID_IMPRESSION_EVENT_NAMES:[Ljava/lang/String;

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    if-le v1, v2, :cond_1

    .line 85
    const-string v0, "IMPRESSION"

    .line 93
    :cond_0
    :goto_0
    return-object v0

    .line 87
    :cond_1
    sget-object v1, Ltv/freewheel/hybrid/ad/EventCallback;->VALID_STANDARD_EVENT_NAMES:[Ljava/lang/String;

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    if-le v1, v2, :cond_2

    .line 88
    const-string v0, "STANDARD"

    goto :goto_0

    .line 90
    :cond_2
    sget-object v1, Ltv/freewheel/hybrid/ad/EventCallback;->VALID_ERROR_EVENT_NAMES:[Ljava/lang/String;

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v1

    if-le v1, v2, :cond_0

    .line 91
    const-string v0, "ERROR"

    goto :goto_0
.end method

.method public static final getShortenedEventType(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "eventType"    # Ljava/lang/String;

    .prologue
    .line 97
    sget-object v1, Ltv/freewheel/hybrid/ad/EventCallback;->EVENT_TYPES:[Ljava/lang/String;

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p0}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v0

    .line 98
    .local v0, "index":I
    const/4 v1, -0x1

    if-le v0, v1, :cond_0

    .line 99
    sget-object v1, Ltv/freewheel/hybrid/ad/EventCallback;->SHORT_EVENT_TYPES:[Ljava/lang/String;

    aget-object v1, v1, v0

    .line 101
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private parseTrackingUrl(Lorg/w3c/dom/Element;)V
    .locals 7
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 43
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 44
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v5

    if-ge v2, v5, :cond_1

    .line 45
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 46
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_0

    .line 47
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 48
    .local v3, "name":Ljava/lang/String;
    const-string v5, "url"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    move-object v4, v1

    .line 49
    check-cast v4, Lorg/w3c/dom/Element;

    .line 50
    .local v4, "url":Lorg/w3c/dom/Element;
    iget-object v5, p0, Ltv/freewheel/hybrid/ad/EventCallback;->trackingURLs:Ljava/util/ArrayList;

    const-string v6, "value"

    invoke-interface {v4, v6}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 44
    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "url":Lorg/w3c/dom/Element;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 54
    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    :cond_1
    return-void
.end method

.method public static validate(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 4
    .param p0, "eventName"    # Ljava/lang/String;
    .param p1, "eventType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    .local p2, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 69
    .local v0, "errors":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-eqz p1, :cond_0

    const-string v2, ""

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 70
    :cond_0
    const-string v2, "eventType is empty."

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 72
    :cond_1
    if-eqz p2, :cond_2

    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-nez v2, :cond_3

    .line 73
    :cond_2
    const-string v2, "URLs is empty."

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 75
    :cond_3
    invoke-static {p0}, Ltv/freewheel/hybrid/ad/EventCallback;->getEventTypeByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 76
    .local v1, "et":Ljava/lang/String;
    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 77
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Not a valid combination: eventName is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " and eventType is "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 79
    :cond_4
    return-object v0
.end method


# virtual methods
.method public cloneForTranslation()Ltv/freewheel/hybrid/ad/EventCallback;
    .locals 3

    .prologue
    .line 57
    new-instance v0, Ltv/freewheel/hybrid/ad/EventCallback;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/EventCallback;->context:Ltv/freewheel/hybrid/ad/AdContext;

    invoke-direct {v0, v1}, Ltv/freewheel/hybrid/ad/EventCallback;-><init>(Ltv/freewheel/hybrid/ad/AdContext;)V

    .line 58
    .local v0, "ret":Ltv/freewheel/hybrid/ad/EventCallback;
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/EventCallback;->usage:Ljava/lang/String;

    iput-object v1, v0, Ltv/freewheel/hybrid/ad/EventCallback;->usage:Ljava/lang/String;

    .line 59
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/EventCallback;->type:Ljava/lang/String;

    iput-object v1, v0, Ltv/freewheel/hybrid/ad/EventCallback;->type:Ljava/lang/String;

    .line 60
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/EventCallback;->name:Ljava/lang/String;

    iput-object v1, v0, Ltv/freewheel/hybrid/ad/EventCallback;->name:Ljava/lang/String;

    .line 61
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/EventCallback;->url:Ljava/lang/String;

    iput-object v1, v0, Ltv/freewheel/hybrid/ad/EventCallback;->url:Ljava/lang/String;

    .line 62
    iget-boolean v1, p0, Ltv/freewheel/hybrid/ad/EventCallback;->showBrowser:Z

    iput-boolean v1, v0, Ltv/freewheel/hybrid/ad/EventCallback;->showBrowser:Z

    .line 63
    iget-object v1, v0, Ltv/freewheel/hybrid/ad/EventCallback;->trackingURLs:Ljava/util/ArrayList;

    iget-object v2, p0, Ltv/freewheel/hybrid/ad/EventCallback;->trackingURLs:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 64
    return-object v0
.end method

.method public parse(Lorg/w3c/dom/Element;)V
    .locals 6
    .param p1, "node"    # Lorg/w3c/dom/Element;

    .prologue
    .line 24
    const-string v4, "use"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/EventCallback;->usage:Ljava/lang/String;

    .line 25
    const-string v4, "type"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/EventCallback;->type:Ljava/lang/String;

    .line 26
    const-string v4, "name"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/EventCallback;->name:Ljava/lang/String;

    .line 27
    const-string v4, "url"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/ad/EventCallback;->url:Ljava/lang/String;

    .line 28
    const-string v4, "showBrowser"

    invoke-interface {p1, v4}, Lorg/w3c/dom/Element;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    iput-boolean v4, p0, Ltv/freewheel/hybrid/ad/EventCallback;->showBrowser:Z

    .line 30
    invoke-interface {p1}, Lorg/w3c/dom/Element;->getChildNodes()Lorg/w3c/dom/NodeList;

    move-result-object v0

    .line 31
    .local v0, "childList":Lorg/w3c/dom/NodeList;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v0}, Lorg/w3c/dom/NodeList;->getLength()I

    move-result v4

    if-ge v2, v4, :cond_1

    .line 32
    invoke-interface {v0, v2}, Lorg/w3c/dom/NodeList;->item(I)Lorg/w3c/dom/Node;

    move-result-object v1

    .line 33
    .local v1, "childNode":Lorg/w3c/dom/Node;
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeType()S

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_0

    .line 34
    invoke-interface {v1}, Lorg/w3c/dom/Node;->getNodeName()Ljava/lang/String;

    move-result-object v3

    .line 35
    .local v3, "name":Ljava/lang/String;
    const-string v4, "trackingURLs"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 36
    check-cast v1, Lorg/w3c/dom/Element;

    .end local v1    # "childNode":Lorg/w3c/dom/Node;
    invoke-direct {p0, v1}, Ltv/freewheel/hybrid/ad/EventCallback;->parseTrackingUrl(Lorg/w3c/dom/Element;)V

    .line 31
    .end local v3    # "name":Ljava/lang/String;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 40
    :cond_1
    return-void
.end method
