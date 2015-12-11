.class public Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
.super Ljava/lang/Object;
.source "RetailSearchQuery.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Lcom/amazon/retailsearch/android/api/query/Query;


# static fields
.field private static final ALIAS_REFINEMENT:Ljava/lang/String; = "i"

.field private static final APS_ALIAS:Ljava/lang/String; = "aps"

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;"
        }
    .end annotation
.end field

.field public static final INTENT_EXTRA_KEY:Ljava/lang/String;

.field private static final KEYWORDS_REFINEMENT:Ljava/lang/String; = "k"

.field private static final NODE_REFINEMENT:Ljava/lang/String; = "n"

.field private static final REFINEMENT_SEPERATOR:Ljava/lang/String; = ","

.field private static final REFINEMENT_VALUE_SEPARATOR:Ljava/lang/String; = ":"


# instance fields
.field private alias:Ljava/lang/String;

.field private asrRequestId:Ljava/lang/String;

.field private interpretationNum:I

.field private issEngagementData:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private keywords:Ljava/lang/String;

.field private node:J

.field private rawUserInput:Ljava/lang/String;

.field private searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

.field private searchUrl:Ljava/lang/String;

.field private source:Lcom/amazon/retailsearch/android/api/query/QuerySource;

.field private utteranceId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    const-class v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->INTENT_EXTRA_KEY:Ljava/lang/String;

    .line 425
    new-instance v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery$1;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery$1;-><init>()V

    sput-object v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    return-void
.end method

.method public constructor <init>(Landroid/net/Uri;)V
    .locals 1
    .param p1, "searchUri"    # Landroid/net/Uri;

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 0
    .param p1, "srcParcel"    # Landroid/os/Parcel;

    .prologue
    .line 127
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 128
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->readFromParcel(Landroid/os/Parcel;)V

    .line 129
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "keywords"    # Ljava/lang/String;

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 74
    const-string/jumbo v0, "aps"

    iput-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    .line 75
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "alias"    # Ljava/lang/String;
    .param p2, "keywords"    # Ljava/lang/String;

    .prologue
    .line 85
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 86
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    .line 87
    iput-object p2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "alias"    # Ljava/lang/String;
    .param p2, "keywords"    # Ljava/lang/String;
    .param p3, "rawUserInput"    # Ljava/lang/String;

    .prologue
    .line 98
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 99
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    .line 100
    iput-object p2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    .line 101
    iput-object p3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->rawUserInput:Ljava/lang/String;

    .line 102
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 0
    .param p1, "alias"    # Ljava/lang/String;
    .param p2, "keywords"    # Ljava/lang/String;
    .param p3, "rawUserInput"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 113
    .local p4, "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 114
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    .line 115
    iput-object p2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    .line 116
    iput-object p3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->rawUserInput:Ljava/lang/String;

    .line 117
    iput-object p4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->issEngagementData:Ljava/util/Map;

    .line 118
    return-void
.end method

.method private addRefinementItem(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "refinement"    # Ljava/lang/StringBuilder;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 341
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 343
    const-string/jumbo v0, ","

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 345
    :cond_0
    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 346
    return-void
.end method

.method public static fromUrl(Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 507
    new-instance v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>()V

    .line 508
    .local v0, "q":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->setSearchUrl(Ljava/lang/String;)V

    .line 509
    return-object v0
.end method

.method private readFromParcel(Landroid/os/Parcel;)V
    .locals 6
    .param p1, "srcParcel"    # Landroid/os/Parcel;

    .prologue
    .line 398
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->rawUserInput:Ljava/lang/String;

    .line 399
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    .line 400
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    .line 401
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->node:J

    .line 402
    const-class v4, Lcom/amazon/retailsearch/android/api/query/QuerySource;

    invoke-virtual {v4}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v4

    invoke-virtual {p1, v4}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v4

    check-cast v4, Lcom/amazon/retailsearch/android/api/query/QuerySource;

    iput-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->source:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    .line 403
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->find(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 404
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    .line 405
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->asrRequestId:Ljava/lang/String;

    .line 406
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->utteranceId:Ljava/lang/String;

    .line 407
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v4

    iput v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->interpretationNum:I

    .line 408
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v2

    .line 409
    .local v2, "size":I
    if-lez v2, :cond_0

    .line 411
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    iput-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->issEngagementData:Ljava/util/Map;

    .line 412
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v2, :cond_0

    .line 414
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    .line 415
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v3

    .line 416
    .local v3, "value":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->issEngagementData:Ljava/util/Map;

    invoke-interface {v4, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 412
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 419
    .end local v0    # "i":I
    .end local v1    # "key":Ljava/lang/String;
    .end local v3    # "value":Ljava/lang/String;
    :cond_0
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 354
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 524
    if-nez p1, :cond_1

    .line 537
    :cond_0
    :goto_0
    return v2

    .line 528
    :cond_1
    if-ne p1, p0, :cond_2

    move v2, v1

    .line 530
    goto :goto_0

    .line 532
    :cond_2
    instance-of v3, p1, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    if-eqz v3, :cond_0

    move-object v0, p1

    .line 536
    check-cast v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    .line 537
    .local v0, "rsq":Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;
    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/amazon/retailsearch/util/Utils;->isEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/amazon/retailsearch/util/Utils;->isEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    iget-wide v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->node:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    iget-wide v4, v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->node:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/retailsearch/util/Utils;->isEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/amazon/retailsearch/util/Utils;->isEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    iget-object v4, v0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    invoke-static {v3, v4}, Lcom/amazon/retailsearch/util/Utils;->isEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    :goto_1
    move v2, v1

    goto :goto_0

    :cond_3
    move v1, v2

    goto :goto_1
.end method

.method public getAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    return-object v0
.end method

.method public getAsrRequestId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 250
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->asrRequestId:Ljava/lang/String;

    return-object v0
.end method

.method public getInterpretationNum()I
    .locals 1

    .prologue
    .line 280
    iget v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->interpretationNum:I

    return v0
.end method

.method public getIssEngagementData()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 193
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->issEngagementData:Ljava/util/Map;

    return-object v0
.end method

.method public getKeywords()Ljava/lang/String;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    return-object v0
.end method

.method public getNode()J
    .locals 2

    .prologue
    .line 152
    iget-wide v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->node:J

    return-wide v0
.end method

.method public getRawUserInput()Ljava/lang/String;
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->rawUserInput:Ljava/lang/String;

    return-object v0
.end method

.method public getRefinementsString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 313
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 315
    .local v0, "refinement":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 317
    const-string/jumbo v1, "i"

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->addRefinementItem(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 320
    :cond_0
    iget-wide v1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->node:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-eqz v1, :cond_1

    .line 322
    const-string/jumbo v1, "n"

    iget-wide v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->node:J

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->addRefinementItem(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 325
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 327
    const-string/jumbo v1, "k"

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->addRefinementItem(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 330
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getSearchMethod()Lcom/amazon/searchapp/retailsearch/client/SearchMethod;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    return-object v0
.end method

.method public getSearchUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getSource()Lcom/amazon/retailsearch/android/api/query/QuerySource;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->source:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    return-object v0
.end method

.method public getUtteranceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 265
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->utteranceId:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 548
    const/16 v0, 0x1d

    .line 549
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 550
    .local v1, "result":I
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v4, 0x1d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_0

    move v1, v2

    .line 551
    :goto_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    mul-int/lit8 v4, v1, 0x1d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_1

    move v1, v2

    .line 552
    :goto_1
    mul-int/lit8 v3, v1, 0x1d

    iget-wide v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->node:J

    long-to-int v4, v4

    add-int v1, v3, v4

    .line 553
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    mul-int/lit8 v4, v1, 0x1d

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_2

    move v1, v2

    .line 554
    :goto_2
    mul-int/lit8 v3, v1, 0x1d

    iget-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    if-nez v4, :cond_3

    :goto_3
    add-int v1, v3, v2

    .line 555
    return v1

    .line 550
    :cond_0
    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_0

    .line 551
    :cond_1
    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_1

    .line 553
    :cond_2
    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_2

    .line 554
    :cond_3
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->hashCode()I

    move-result v2

    goto :goto_3
.end method

.method public isAps()Z
    .locals 2

    .prologue
    .line 518
    const-string/jumbo v0, "aps"

    iget-object v1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isEmptyKeywords()Z
    .locals 1

    .prologue
    .line 304
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method

.method public setAlias(Ljava/lang/String;)V
    .locals 0
    .param p1, "alias"    # Ljava/lang/String;

    .prologue
    .line 225
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    .line 226
    return-void
.end method

.method public setAsrRequestId(Ljava/lang/String;)V
    .locals 0
    .param p1, "asrRequestId"    # Ljava/lang/String;

    .prologue
    .line 258
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->asrRequestId:Ljava/lang/String;

    .line 259
    return-void
.end method

.method public setInterpretationNum(I)V
    .locals 0
    .param p1, "interpretationNum"    # I

    .prologue
    .line 287
    iput p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->interpretationNum:I

    .line 288
    return-void
.end method

.method public setIssEngagementData(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 295
    .local p1, "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->issEngagementData:Ljava/util/Map;

    .line 296
    return-void
.end method

.method public setKeyword(Ljava/lang/String;)V
    .locals 0
    .param p1, "keywords"    # Ljava/lang/String;

    .prologue
    .line 209
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    .line 210
    return-void
.end method

.method public setNode(J)V
    .locals 0
    .param p1, "node"    # J

    .prologue
    .line 217
    iput-wide p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->node:J

    .line 218
    return-void
.end method

.method public setRawUserInput(Ljava/lang/String;)V
    .locals 0
    .param p1, "rawUserInput"    # Ljava/lang/String;

    .prologue
    .line 201
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->rawUserInput:Ljava/lang/String;

    .line 202
    return-void
.end method

.method public setSearchMethod(Lcom/amazon/searchapp/retailsearch/client/SearchMethod;)V
    .locals 0
    .param p1, "searchMethod"    # Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .prologue
    .line 168
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    .line 169
    return-void
.end method

.method public setSearchUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "searchUrl"    # Ljava/lang/String;

    .prologue
    .line 243
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    .line 244
    return-void
.end method

.method public setSource(Lcom/amazon/retailsearch/android/api/query/QuerySource;)V
    .locals 0
    .param p1, "source"    # Lcom/amazon/retailsearch/android/api/query/QuerySource;

    .prologue
    .line 233
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->source:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    .line 234
    return-void
.end method

.method public setUtteranceId(Ljava/lang/String;)V
    .locals 0
    .param p1, "utteranceId"    # Ljava/lang/String;

    .prologue
    .line 273
    iput-object p1, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->utteranceId:Ljava/lang/String;

    .line 274
    return-void
.end method

.method public toSearchRequest()Lcom/amazon/searchapp/retailsearch/client/SearchRequest;
    .locals 5

    .prologue
    .line 453
    new-instance v3, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    invoke-direct {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;-><init>()V

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setImageCrop(Z)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setImageResolution(Ljava/lang/Integer;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    move-result-object v2

    .line 454
    .local v2, "requestBuilder":Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;
    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 456
    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setDataUrl(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    .line 457
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->getKeywords()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setKeywords(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    .line 475
    :goto_0
    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    if-eqz v3, :cond_0

    .line 477
    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    invoke-virtual {v3}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setSearchMethod(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    .line 482
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 484
    .local v0, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->asrRequestId:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 485
    const-string/jumbo v3, "asrRequestId"

    iget-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->asrRequestId:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 488
    :cond_1
    iget-object v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->utteranceId:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 489
    const-string/jumbo v3, "utteranceId"

    iget-object v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->utteranceId:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 492
    :cond_2
    iget v3, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->interpretationNum:I

    if-lez v3, :cond_3

    .line 493
    const-string/jumbo v3, "interpretationNum"

    iget v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->interpretationNum:I

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 496
    :cond_3
    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_4

    .line 497
    invoke-virtual {v2, v0}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setParameters(Ljava/util/Map;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    .line 500
    :cond_4
    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->getInstance()Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->getDeviceInfo()Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setDeviceInformation(Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    .line 502
    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/SearchRequest;

    move-result-object v3

    return-object v3

    .line 461
    .end local v0    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_5
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->getKeywords()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setKeywords(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    .line 462
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->getRefinementsString()Ljava/lang/String;

    move-result-object v1

    .line 464
    .local v1, "refinements":Ljava/lang/String;
    if-nez v1, :cond_6

    .line 466
    const-string/jumbo v3, "aps"

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setAlias(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    goto :goto_0

    .line 470
    :cond_6
    invoke-virtual {v2, v1}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setRefinements(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    .line 471
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;->setAlias(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/SearchRequest$Builder;

    goto :goto_0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 6
    .param p1, "destParcel"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v3, 0x0

    .line 368
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->rawUserInput:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 369
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->alias:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 370
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->keywords:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 371
    iget-wide v4, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->node:J

    invoke-virtual {p1, v4, v5}, Landroid/os/Parcel;->writeLong(J)V

    .line 372
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->source:Lcom/amazon/retailsearch/android/api/query/QuerySource;

    invoke-virtual {p1, v2, v3}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 373
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchMethod:Lcom/amazon/searchapp/retailsearch/client/SearchMethod;

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchMethod;->getName()Ljava/lang/String;

    move-result-object v2

    :goto_0
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 374
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->searchUrl:Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 375
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->asrRequestId:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->asrRequestId:Ljava/lang/String;

    :goto_1
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 376
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->utteranceId:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->utteranceId:Ljava/lang/String;

    :goto_2
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 377
    iget v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->interpretationNum:I

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 378
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->issEngagementData:Ljava/util/Map;

    if-nez v2, :cond_3

    move v2, v3

    :goto_3
    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeInt(I)V

    .line 379
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->issEngagementData:Ljava/util/Map;

    if-eqz v2, :cond_4

    .line 381
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->issEngagementData:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 383
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 384
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->issEngagementData:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {p1, v2}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_4

    .line 373
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "key":Ljava/lang/String;
    :cond_0
    const-string/jumbo v2, ""

    goto :goto_0

    .line 375
    :cond_1
    const-string/jumbo v2, ""

    goto :goto_1

    .line 376
    :cond_2
    const-string/jumbo v2, ""

    goto :goto_2

    .line 378
    :cond_3
    iget-object v2, p0, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;->issEngagementData:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v2

    goto :goto_3

    .line 387
    :cond_4
    return-void
.end method
