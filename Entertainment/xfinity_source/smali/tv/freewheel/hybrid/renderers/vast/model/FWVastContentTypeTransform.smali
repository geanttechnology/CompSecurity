.class public Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTypeTransform;
.super Ljava/lang/Object;
.source "FWVastContentTypeTransform.java"


# static fields
.field static equivalence:[[Ljava/lang/String;

.field private static logger:Ltv/freewheel/hybrid/utils/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 7
    new-array v0, v6, [[Ljava/lang/String;

    const/4 v1, 0x7

    new-array v1, v1, [Ljava/lang/String;

    const-string v2, "text/html_doc_lit_mobile"

    aput-object v2, v1, v4

    const-string v2, "image/gif"

    aput-object v2, v1, v5

    const-string v2, "image/jpeg"

    aput-object v2, v1, v6

    const/4 v2, 0x3

    const-string v3, "image/png"

    aput-object v3, v1, v2

    const/4 v2, 0x4

    const-string v3, "text/html"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    const-string v3, "text/javascript"

    aput-object v3, v1, v2

    const/4 v2, 0x6

    const-string v3, "text/js_ref"

    aput-object v3, v1, v2

    aput-object v1, v0, v4

    new-array v1, v6, [Ljava/lang/String;

    const-string v2, "video/3gpp"

    aput-object v2, v1, v4

    const-string v2, "video/3gp"

    aput-object v2, v1, v5

    aput-object v1, v0, v5

    sput-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTypeTransform;->equivalence:[[Ljava/lang/String;

    .line 12
    const-string v0, "FWVastContentTypeTransform"

    invoke-static {v0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/String;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    sput-object v0, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTypeTransform;->logger:Ltv/freewheel/hybrid/utils/Logger;

    return-void
.end method

.method public static transform(Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p0, "transformee"    # Ljava/lang/String;

    .prologue
    .line 15
    const/4 v4, 0x0

    .line 16
    .local v4, "transformed":Ljava/lang/String;
    if-eqz p0, :cond_2

    .line 17
    move-object v4, p0

    .line 18
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p0

    .line 19
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    sget-object v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTypeTransform;->equivalence:[[Ljava/lang/String;

    array-length v5, v5

    if-ge v1, v5, :cond_2

    .line 20
    sget-object v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTypeTransform;->equivalence:[[Ljava/lang/String;

    aget-object v0, v5, v1

    .line 21
    .local v0, "eqclass":[Ljava/lang/String;
    array-length v5, v0

    const/4 v6, 0x1

    if-ge v5, v6, :cond_1

    .line 19
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 23
    :cond_1
    const/4 v5, 0x0

    aget-object v3, v0, v5

    .line 24
    .local v3, "key":Ljava/lang/String;
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_1
    array-length v5, v0

    if-ge v2, v5, :cond_0

    .line 25
    aget-object v5, v0, v2

    invoke-virtual {p0, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 26
    move-object v4, v3

    .line 32
    .end local v0    # "eqclass":[Ljava/lang/String;
    .end local v1    # "i":I
    .end local v2    # "j":I
    .end local v3    # "key":Ljava/lang/String;
    :cond_2
    sget-object v5, Ltv/freewheel/hybrid/renderers/vast/model/FWVastContentTypeTransform;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "The content type "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " transformed to FW content type "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 33
    return-object v4

    .line 24
    .restart local v0    # "eqclass":[Ljava/lang/String;
    .restart local v1    # "i":I
    .restart local v2    # "j":I
    .restart local v3    # "key":Ljava/lang/String;
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1
.end method
