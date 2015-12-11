.class public Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;
.super Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;
.source "HalLiveFeaturedContent.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
            ">;"
        }
    .end annotation
.end field

.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private description:Ljava/lang/String;

.field private endDate:Ljava/util/Date;

.field private eventId:Ljava/lang/String;

.field private packageName:Ljava/lang/String;

.field private startDate:Ljava/util/Date;

.field private subTitle:Ljava/lang/String;

.field private timeField:Ljava/lang/String;

.field private websiteLink:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->LOG:Lorg/slf4j/Logger;

    .line 128
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent$1;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent$1;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;-><init>(Landroid/os/Parcel;)V

    .line 30
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->description:Ljava/lang/String;

    .line 31
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->subTitle:Ljava/lang/String;

    .line 32
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->timeField:Ljava/lang/String;

    .line 33
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->websiteLink:Ljava/lang/String;

    .line 34
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->eventId:Ljava/lang/String;

    .line 35
    new-instance v0, Ljava/util/Date;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/Date;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->startDate:Ljava/util/Date;

    .line 36
    new-instance v0, Ljava/util/Date;

    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/Date;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->endDate:Ljava/util/Date;

    .line 37
    return-void
.end method

.method private convertDateString(Ljava/lang/String;)Ljava/util/Date;
    .locals 5
    .param p1, "dateString"    # Ljava/lang/String;

    .prologue
    .line 94
    if-eqz p1, :cond_0

    .line 96
    :try_start_0
    new-instance v0, Lcom/fasterxml/jackson/databind/util/ISO8601DateFormat;

    invoke-direct {v0}, Lcom/fasterxml/jackson/databind/util/ISO8601DateFormat;-><init>()V

    .line 97
    .local v0, "dateFormat":Lcom/fasterxml/jackson/databind/util/ISO8601DateFormat;
    invoke-virtual {v0, p1}, Lcom/fasterxml/jackson/databind/util/ISO8601DateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 102
    .end local v0    # "dateFormat":Lcom/fasterxml/jackson/databind/util/ISO8601DateFormat;
    :goto_0
    return-object v2

    .line 98
    :catch_0
    move-exception v1

    .line 99
    .local v1, "e":Ljava/text/ParseException;
    sget-object v2, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->LOG:Lorg/slf4j/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error parsing live stream featured content date : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 102
    .end local v1    # "e":Ljava/text/ParseException;
    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 107
    const/4 v0, 0x1

    return v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getEndDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->endDate:Ljava/util/Date;

    return-object v0
.end method

.method public getEventId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->eventId:Ljava/lang/String;

    return-object v0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->packageName:Ljava/lang/String;

    return-object v0
.end method

.method public getStartDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->startDate:Ljava/util/Date;

    return-object v0
.end method

.method public getSubTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->subTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getTimeField()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->timeField:Ljava/lang/String;

    return-object v0
.end method

.method public getWebsiteLink()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->websiteLink:Ljava/lang/String;

    return-object v0
.end method

.method public parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V
    .locals 3
    .param p1, "resolver"    # Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    .prologue
    .line 41
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->parseHalContent(Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;)V

    .line 43
    const-string v2, "subtitle"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->subTitle:Ljava/lang/String;

    .line 44
    const-string v2, "description"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->description:Ljava/lang/String;

    .line 45
    const-string v2, "timeField"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->timeField:Ljava/lang/String;

    .line 46
    const-string v2, "packageName"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->packageName:Ljava/lang/String;

    .line 47
    const-string v2, "website"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalLinkAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->websiteLink:Ljava/lang/String;

    .line 48
    const-string v2, "start"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->convertDateString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->startDate:Ljava/util/Date;

    .line 49
    const-string v2, "end"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->convertDateString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->endDate:Ljava/util/Date;

    .line 51
    const-string v2, "parameters"

    invoke-virtual {p1, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchItem(Ljava/lang/String;)Lcom/comcast/cim/microdata/model/MicrodataItem;

    move-result-object v1

    .line 53
    .local v1, "parameters":Lcom/comcast/cim/microdata/model/MicrodataItem;
    if-eqz v1, :cond_0

    .line 54
    invoke-virtual {p1, v1}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->copy(Lcom/comcast/cim/microdata/model/MicrodataItem;)Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;

    move-result-object v0

    .line 57
    .local v0, "parameterResolver":Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;
    const-string v2, "eventid"

    invoke-virtual {v0, v2}, Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;->fetchOptionalString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->eventId:Ljava/lang/String;

    .line 59
    .end local v0    # "parameterResolver":Lcom/comcast/cim/cmasl/hal/model/MicrodataPropertyResolver;
    :cond_0
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 112
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;->writeToParcel(Landroid/os/Parcel;I)V

    .line 113
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->description:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 114
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->subTitle:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 115
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->timeField:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 116
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->websiteLink:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 117
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->eventId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 119
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->startDate:Ljava/util/Date;

    if-eqz v0, :cond_0

    .line 120
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->startDate:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 123
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->endDate:Ljava/util/Date;

    if-eqz v0, :cond_1

    .line 124
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->endDate:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 126
    :cond_1
    return-void
.end method
