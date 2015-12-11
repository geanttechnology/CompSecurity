.class public Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;
.super Ljava/lang/Object;
.source "FWVastContentTransform.java"


# static fields
.field private static instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

.field private static logger:Ltv/freewheel/hybrid/utils/Logger;


# instance fields
.field private macros:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    sput-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    .line 25
    const-string v0, "FWVastContentTransform"

    invoke-static {v0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/String;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    sput-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 26
    new-instance v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    invoke-direct {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    .line 27
    sget-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->setDefaultMacros()V

    .line 28
    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    .line 32
    return-void
.end method

.method public static clearMacros()V
    .locals 1

    .prologue
    .line 40
    sget-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 41
    sget-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->setDefaultMacros()V

    .line 42
    return-void
.end method

.method public static image_TO_text_html_doc_lit_mobile(Ljava/lang/String;IILjava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "content"    # Ljava/lang/String;
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "alt"    # Ljava/lang/String;

    .prologue
    .line 118
    const/4 v2, 0x0

    invoke-static {v2}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->setRequestPageURL(Ljava/lang/String;)V

    .line 119
    const-string v1, "100%"

    .line 120
    .local v1, "strWidth":Ljava/lang/String;
    const-string v0, "100%"

    .line 121
    .local v0, "strHeight":Ljava/lang/String;
    if-lez p1, :cond_0

    .line 122
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 123
    :cond_0
    if-lez p2, :cond_1

    .line 124
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 126
    :cond_1
    sget-object v2, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    iget-object v2, v2, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v3, "#{ad.creative.width}"

    invoke-virtual {v2, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    sget-object v2, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    iget-object v2, v2, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v3, "#{ad.creative.height}"

    invoke-virtual {v2, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 128
    if-nez p3, :cond_2

    .line 129
    const-string p3, ""

    .line 130
    :cond_2
    sget-object v2, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    iget-object v2, v2, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v3, "#{altText_VAST}"

    invoke-virtual {v2, v3, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 134
    sget-object v2, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    invoke-virtual {v2, p0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->injectContent(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v2

    invoke-virtual {v2}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->ImgRef_to_HTMLLit()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v2

    invoke-virtual {v2}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->HTMLLit_to_HTMLLit_deco()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v2

    invoke-virtual {v2}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->HTMLLit_to_HTMLDocLit_mobile()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v2

    invoke-virtual {v2}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->retrieveContent()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static injectCallback(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p0, "content"    # Ljava/lang/String;
    .param p1, "clickURL"    # Ljava/lang/String;
    .param p3, "safeId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 83
    .local p2, "trackingURLs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    invoke-static {}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->clearMacros()V

    .line 84
    if-nez p1, :cond_0

    .line 85
    const-string p1, "#"

    .line 86
    :cond_0
    sget-object v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    iget-object v5, v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v6, "#{click(\"defaultClick\")}"

    invoke-virtual {v5, v6, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    if-nez p3, :cond_1

    .line 90
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v6

    const-wide v8, 0x412e848000000000L    # 1000000.0

    mul-double/2addr v6, v8

    double-to-int v6, v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 92
    :cond_1
    sget-object v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    iget-object v5, v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v6, "#{slot.safeId}"

    invoke-virtual {v5, v6, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 94
    const-string v2, "{}"

    .line 95
    .local v2, "jsTrackingURLs":Ljava/lang/String;
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_4

    .line 96
    const/4 v1, 0x0

    .line 97
    .local v1, "js":Ljava/lang/StringBuffer;
    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 98
    .local v4, "url":Ljava/lang/String;
    if-nez v1, :cond_2

    .line 99
    new-instance v1, Ljava/lang/StringBuffer;

    .end local v1    # "js":Ljava/lang/StringBuffer;
    const-string v5, "["

    invoke-direct {v1, v5}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 103
    .restart local v1    # "js":Ljava/lang/StringBuffer;
    :goto_1
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "\""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 101
    :cond_2
    const-string v5, ","

    invoke-virtual {v1, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 105
    .end local v4    # "url":Ljava/lang/String;
    :cond_3
    const-string v5, "]"

    invoke-virtual {v1, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 106
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "[{\"name\":\"defaultClick\",\"url\":\""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\",\"trackingURLs\":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "}]"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 108
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "js":Ljava/lang/StringBuffer;
    :cond_4
    sget-object v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    iget-object v5, v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v6, "#{jsClickArray}"

    invoke-virtual {v5, v6, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    sget-object v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    invoke-virtual {v5, p0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->applyMacros(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    .line 110
    sget-object v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "The defaultClick:"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ", trackingURLs:"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " are injected"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 111
    sget-object v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    invoke-virtual {v5}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->retrieveContent()Ljava/lang/String;

    move-result-object v3

    .line 112
    .local v3, "ret":Ljava/lang/String;
    invoke-static {}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->clearMacros()V

    .line 113
    return-object v3
.end method

.method private static setRequestPageURL(Ljava/lang/String;)V
    .locals 2
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 51
    if-nez p0, :cond_0

    .line 52
    const-string p0, ""

    .line 53
    :cond_0
    sget-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    iget-object v0, v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v1, "#j{request.pageUrl}"

    invoke-virtual {v0, v1, p0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    return-void
.end method

.method public static text_html_TO_text_html_doc_lit_mobile(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "content"    # Ljava/lang/String;

    .prologue
    .line 66
    const/4 v0, 0x0

    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->setRequestPageURL(Ljava/lang/String;)V

    .line 67
    sget-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->injectContent(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->HTMLLit_to_HTMLLit_deco()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->HTMLLit_to_HTMLDocLit_mobile()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->retrieveContent()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static text_js_ref_TO_text_html_doc_lit_mobile(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "content"    # Ljava/lang/String;

    .prologue
    .line 57
    const/4 v0, 0x0

    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->setRequestPageURL(Ljava/lang/String;)V

    .line 58
    sget-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->instance:Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    invoke-virtual {v0, p0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->injectContent(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->JSRef_to_HTMLLit()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->HTMLLit_to_HTMLLit_deco()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->HTMLLit_to_HTMLDocLit_mobile()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->retrieveContent()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method HTMLLit_to_HTMLDocLit_mobile()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;
    .locals 2

    .prologue
    .line 232
    const-string v0, "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta name = \"viewport\" content = \"initial-scale = 1.0, target-densitydpi = device-dpi\" /><title>Advertisement</title><script type=\"text/javascript\">window._fw_page_url = \"#j{request.pageUrl}\";</script></head><body style=\"margin:0px;background-color:transparent;\">#{content}</body></html>"

    .line 242
    .local v0, "template":Ljava/lang/String;
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->applyMacros(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v1

    return-object v1
.end method

.method HTMLLit_to_HTMLLit_deco()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;
    .locals 2

    .prologue
    .line 224
    const-string v0, "<span style=\"display:inline-block; vertical-align:top; margin:#{ad.creative.marginHeight}px #{ad.creative.marginWidth}px #{ad.creative.marginHeight}px #{ad.creative.marginWidth}px;\">#{content}</span>"

    .line 227
    .local v0, "template":Ljava/lang/String;
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->applyMacros(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v1

    return-object v1
.end method

.method ImgRef_to_HTMLLit()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;
    .locals 2

    .prologue
    .line 247
    const-string v0, "<a href=\"#{click(\"defaultClick\")}\" target=\"_blank\" onclick=\"window._fw_admanager.pingCallback(\'click_#{slot.safeId}\');\"><img src=\"#{content}\" width=\"#{ad.creative.width}\" height=\"#{ad.creative.height}\" border=\"0\" alt=\"#{altText_VAST}\"></a><script type=\"text/javascript\">if (!window._fw_admanager) window._fw_admanager = {};if (!window._fw_admanager.pingCallback) window._fw_admanager.pingCallback = function(id) {    var u = window._fw_admanager.callback[id];    if (!u || !u.length) return;    for (var i=0;i<u.length;i++) {\t\tif (u[i].name!=\"defaultClick\" || !u[i].trackingURLs || !u[i].trackingURLs.length) continue;\t\tfor (var j=0;j<u[i].trackingURLs.length;j++) {\t\t\tvar f = document.createElement(\'iframe\');\t\t\tvar safeId = id+\"_\"+j;\t\t\tvar callbackURL = u[i].trackingURLs[j];\t\t\tf.name = \'_fw_cb_\' + safeId;\t\t\tif (navigator.appVersion.match(/\\bMSIE\\b/)) f = document.createElement(\'<iframe name=\"\'+\'_fw_cb_\' + safeId+\'\"></iframe>\');\t\t\tf.id = \'_fw_cb_\' + safeId;\t\t\tf.width=\"0\";\t\t\tf.height=\"0\";           f.scrolling=\"no\";\t\t\tf.frameborder=\"0\";\t\t\tf.style.position=\"absolute\";\t\t\tf.style.bottom=\"0\";\t\t\tf.style.right=\"0\";\t\t\tf.src = callbackURL;\t\t\tif (document.body) document.body.appendChild(f);\t\t}    }}\n if (!window._fw_admanager.callback) window._fw_admanager.callback = {};\n window._fw_admanager.callback[\"click_#{slot.safeId}\"] = #{jsClickArray};</script>"

    .line 277
    .local v0, "template":Ljava/lang/String;
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->applyMacros(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v1

    return-object v1
.end method

.method JSRef_to_HTMLLit()Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;
    .locals 2

    .prologue
    .line 216
    const-string v0, "<script src=\"#{content}\" type=\"text/javascript\" language=\"javascript\"></script>"

    .line 219
    .local v0, "template":Ljava/lang/String;
    invoke-virtual {p0, v0}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->applyMacros(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    move-result-object v1

    return-object v1
.end method

.method applyMacros(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;
    .locals 9
    .param p1, "template"    # Ljava/lang/String;

    .prologue
    .line 178
    sget-object v7, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v8, "applyMacros"

    invoke-virtual {v7, v8}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 179
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v7

    if-nez v7, :cond_1

    .line 200
    :cond_0
    :goto_0
    return-object p0

    .line 181
    :cond_1
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4, p1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 182
    .local v4, "muttemplate":Ljava/lang/StringBuffer;
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    invoke-virtual {v7}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 183
    .local v3, "key":Ljava/lang/String;
    iget-object v7, p0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    invoke-virtual {v7, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 184
    .local v6, "value":Ljava/lang/String;
    const-string v7, "#j{"

    invoke-virtual {v3, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 185
    invoke-virtual {p0, v6}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->jsescape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 187
    :cond_2
    const/4 v5, 0x0

    .line 188
    .local v5, "start":I
    invoke-virtual {v4, v3}, Ljava/lang/StringBuffer;->indexOf(Ljava/lang/String;)I

    move-result v2

    .line 189
    .local v2, "idx":I
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 190
    .local v0, "entity":Ljava/lang/StringBuffer;
    :goto_2
    if-lez v2, :cond_3

    .line 191
    invoke-virtual {v4, v5, v2}, Ljava/lang/StringBuffer;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 192
    invoke-virtual {v0, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 193
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v7

    add-int v5, v2, v7

    .line 194
    invoke-virtual {v4, v3, v5}, Ljava/lang/StringBuffer;->indexOf(Ljava/lang/String;I)I

    move-result v2

    goto :goto_2

    .line 196
    :cond_3
    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->substring(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 197
    move-object v4, v0

    .line 198
    goto :goto_1

    .line 199
    .end local v0    # "entity":Ljava/lang/StringBuffer;
    .end local v2    # "idx":I
    .end local v3    # "key":Ljava/lang/String;
    .end local v5    # "start":I
    .end local v6    # "value":Ljava/lang/String;
    :cond_4
    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0, v7}, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->injectContent(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;

    goto :goto_0
.end method

.method injectContent(Ljava/lang/String;)Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;
    .locals 2
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 166
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    .line 167
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v1, "#{content}"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 168
    :cond_0
    return-object p0
.end method

.method jsescape(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "escapee"    # Ljava/lang/String;

    .prologue
    .line 144
    if-nez p1, :cond_0

    .line 145
    const/4 v3, 0x0

    .line 162
    :goto_0
    return-object v3

    .line 146
    :cond_0
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 147
    .local v2, "result":Ljava/lang/StringBuffer;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 148
    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 149
    .local v0, "c":C
    sparse-switch v0, :sswitch_data_0

    .line 159
    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 147
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 150
    :sswitch_0
    const-string v3, "\\\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 151
    :sswitch_1
    const-string v3, "\\\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 152
    :sswitch_2
    const-string v3, "\\&"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 153
    :sswitch_3
    const-string v3, "\\\\"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 154
    :sswitch_4
    const-string v3, "\\r"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 155
    :sswitch_5
    const-string v3, "\\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 156
    :sswitch_6
    const-string v3, "\\t"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 157
    :sswitch_7
    const-string v3, "\\b"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 158
    :sswitch_8
    const-string v3, "\\f"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 162
    .end local v0    # "c":C
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .line 149
    :sswitch_data_0
    .sparse-switch
        0x8 -> :sswitch_7
        0x9 -> :sswitch_6
        0xa -> :sswitch_5
        0xc -> :sswitch_8
        0xd -> :sswitch_4
        0x22 -> :sswitch_1
        0x26 -> :sswitch_2
        0x27 -> :sswitch_0
        0x5c -> :sswitch_3
    .end sparse-switch
.end method

.method retrieveContent()Ljava/lang/String;
    .locals 3

    .prologue
    .line 172
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v2, "#{content}"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 173
    .local v0, "ret":Ljava/lang/String;
    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v2, "#{content}"

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 174
    return-object v0
.end method

.method setDefaultMacros()V
    .locals 3

    .prologue
    .line 35
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v1, "#{ad.creative.marginWidth}"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 36
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTransform;->macros:Ljava/util/HashMap;

    const-string v1, "#{ad.creative.marginHeight}"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    return-void
.end method
