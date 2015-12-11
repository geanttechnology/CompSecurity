.class public final enum Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;
.super Ljava/lang/Enum;
.source "DataTrackInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/ave/DataTrackInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DataTrackInfoServiceType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

.field public static final enum DATATYPE_608Captions:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

.field public static final enum DATATYPE_708Captions:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

.field public static final enum DATATYPE_WebVTTCaptions:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 29
    new-instance v0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    const-string v1, "DATATYPE_608Captions"

    invoke-direct {v0, v1, v2, v2}, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->DATATYPE_608Captions:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    .line 30
    new-instance v0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    const-string v1, "DATATYPE_708Captions"

    invoke-direct {v0, v1, v3, v3}, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->DATATYPE_708Captions:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    .line 31
    new-instance v0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    const-string v1, "DATATYPE_WebVTTCaptions"

    invoke-direct {v0, v1, v4, v4}, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->DATATYPE_WebVTTCaptions:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    .line 27
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    sget-object v1, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->DATATYPE_608Captions:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->DATATYPE_708Captions:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->DATATYPE_WebVTTCaptions:Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->$VALUES:[Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "val"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 40
    iput p3, p0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->value:I

    .line 41
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 27
    const-class v0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->$VALUES:[Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    invoke-virtual {v0}, [Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;

    return-object v0
.end method


# virtual methods
.method public getValue()I
    .locals 1

    .prologue
    .line 47
    iget v0, p0, Lcom/adobe/ave/DataTrackInfo$DataTrackInfoServiceType;->value:I

    return v0
.end method
