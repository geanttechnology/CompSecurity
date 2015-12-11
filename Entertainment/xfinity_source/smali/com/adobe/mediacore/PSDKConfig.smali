.class public final Lcom/adobe/mediacore/PSDKConfig;
.super Ljava/lang/Object;


# static fields
.field public static final DEFAULT_AD_TAG:Ljava/lang/String; = "#EXT-X-CUE"

.field private static _adTags:[Ljava/lang/String;

.field private static _subscribedTags:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static addDefaultAdTag([Ljava/lang/String;)[Ljava/lang/String;
    .locals 6

    const/4 v5, 0x1

    const/4 v1, 0x0

    if-nez p0, :cond_1

    new-array p0, v5, [Ljava/lang/String;

    const-string v0, "#EXT-X-CUE"

    aput-object v0, p0, v1

    :cond_0
    :goto_0
    return-object p0

    :cond_1
    array-length v2, p0

    move v0, v1

    :goto_1
    if-ge v0, v2, :cond_2

    aget-object v3, p0, v0

    const-string v4, "#EXT-X-CUE"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2
    array-length v0, p0

    add-int/lit8 v0, v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const-string v2, "#EXT-X-CUE"

    aput-object v2, v0, v1

    array-length v2, p0

    invoke-static {p0, v1, v0, v5, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    move-object p0, v0

    goto :goto_0
.end method

.method public static getAdTags()[Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/PSDKConfig;->_adTags:[Ljava/lang/String;

    return-object v0
.end method

.method protected static getAdTagsWithDefault()[Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/PSDKConfig;->_adTags:[Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/PSDKConfig;->addDefaultAdTag([Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSubscribedTags()[Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/PSDKConfig;->_subscribedTags:[Ljava/lang/String;

    return-object v0
.end method

.method public static setAdTags([Ljava/lang/String;)V
    .locals 5

    if-nez p0, :cond_0

    const/4 v0, 0x0

    sput-object v0, Lcom/adobe/mediacore/PSDKConfig;->_adTags:[Ljava/lang/String;

    :goto_0
    return-void

    :cond_0
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    array-length v3, p0

    const/4 v0, 0x0

    move v1, v0

    :goto_1
    if-ge v1, v3, :cond_3

    aget-object v0, p0, v1

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    :cond_1
    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Array can not contain null or empty values."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    invoke-interface {v2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    :cond_3
    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v0

    new-array v0, v0, [Ljava/lang/String;

    invoke-interface {v2, v0}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    sput-object v0, Lcom/adobe/mediacore/PSDKConfig;->_adTags:[Ljava/lang/String;

    goto :goto_0
.end method

.method public static setSubscribedTags([Ljava/lang/String;)V
    .locals 5

    if-nez p0, :cond_0

    const/4 v0, 0x0

    sput-object v0, Lcom/adobe/mediacore/PSDKConfig;->_subscribedTags:[Ljava/lang/String;

    :goto_0
    return-void

    :cond_0
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    array-length v3, p0

    const/4 v0, 0x0

    move v1, v0

    :goto_1
    if-ge v1, v3, :cond_3

    aget-object v0, p0, v1

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    :cond_1
    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Array can not contain null or empty values."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    invoke-interface {v2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    :cond_3
    invoke-interface {v2}, Ljava/util/Set;->size()I

    move-result v0

    new-array v0, v0, [Ljava/lang/String;

    invoke-interface {v2, v0}, Ljava/util/Set;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    sput-object v0, Lcom/adobe/mediacore/PSDKConfig;->_subscribedTags:[Ljava/lang/String;

    goto :goto_0
.end method
