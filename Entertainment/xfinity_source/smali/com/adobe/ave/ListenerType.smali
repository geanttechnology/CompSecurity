.class public final enum Lcom/adobe/ave/ListenerType;
.super Ljava/lang/Enum;
.source "ListenerType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/ListenerType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/ListenerType;

.field public static final enum BACKGROUND_MANIFEST_ERROR:Lcom/adobe/ave/ListenerType;

.field public static final enum BACKGROUND_MANIFEST_WARNING:Lcom/adobe/ave/ListenerType;

.field public static final enum DATA:Lcom/adobe/ave/ListenerType;

.field public static final enum DICTIONARY_DATA:Lcom/adobe/ave/ListenerType;

.field public static final enum DRM_ERROR:Lcom/adobe/ave/ListenerType;

.field public static final enum DRM_METADATA:Lcom/adobe/ave/ListenerType;

.field public static final enum ERROR:Lcom/adobe/ave/ListenerType;

.field public static final enum LOAD_INFO:Lcom/adobe/ave/ListenerType;

.field public static final enum MANIFEST_LOAD:Lcom/adobe/ave/ListenerType;

.field public static final enum PLAY_STATE:Lcom/adobe/ave/ListenerType;

.field public static final enum SEEK_COMPLETE:Lcom/adobe/ave/ListenerType;

.field public static final enum STREAM_METADATA:Lcom/adobe/ave/ListenerType;

.field public static final enum STREAM_SWITCH:Lcom/adobe/ave/ListenerType;

.field public static final enum TIMELINE:Lcom/adobe/ave/ListenerType;

.field public static final enum TRICK_PLAY_ENDED:Lcom/adobe/ave/ListenerType;

.field public static final enum WARNING:Lcom/adobe/ave/ListenerType;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    const/16 v7, 0x8

    const/4 v6, 0x4

    const/4 v5, 0x2

    const/4 v4, 0x1

    .line 29
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "ERROR"

    invoke-direct {v0, v1, v8, v4}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->ERROR:Lcom/adobe/ave/ListenerType;

    .line 34
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "PLAY_STATE"

    invoke-direct {v0, v1, v4, v5}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->PLAY_STATE:Lcom/adobe/ave/ListenerType;

    .line 39
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "STREAM_SWITCH"

    invoke-direct {v0, v1, v5, v6}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->STREAM_SWITCH:Lcom/adobe/ave/ListenerType;

    .line 44
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "STREAM_METADATA"

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2, v7}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->STREAM_METADATA:Lcom/adobe/ave/ListenerType;

    .line 49
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "DRM_METADATA"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v6, v2}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->DRM_METADATA:Lcom/adobe/ave/ListenerType;

    .line 54
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "TIMELINE"

    const/4 v2, 0x5

    const/16 v3, 0x20

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->TIMELINE:Lcom/adobe/ave/ListenerType;

    .line 59
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "DATA"

    const/4 v2, 0x6

    const/16 v3, 0x40

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->DATA:Lcom/adobe/ave/ListenerType;

    .line 64
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "MANIFEST_LOAD"

    const/4 v2, 0x7

    const/16 v3, 0x80

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->MANIFEST_LOAD:Lcom/adobe/ave/ListenerType;

    .line 69
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "SEEK_COMPLETE"

    const/16 v2, 0x100

    invoke-direct {v0, v1, v7, v2}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->SEEK_COMPLETE:Lcom/adobe/ave/ListenerType;

    .line 74
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "WARNING"

    const/16 v2, 0x9

    const/16 v3, 0x200

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->WARNING:Lcom/adobe/ave/ListenerType;

    .line 79
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "DICTIONARY_DATA"

    const/16 v2, 0xa

    const/16 v3, 0x400

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->DICTIONARY_DATA:Lcom/adobe/ave/ListenerType;

    .line 84
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "LOAD_INFO"

    const/16 v2, 0xb

    const/16 v3, 0x800

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->LOAD_INFO:Lcom/adobe/ave/ListenerType;

    .line 89
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "TRICK_PLAY_ENDED"

    const/16 v2, 0xc

    const/16 v3, 0x1000

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->TRICK_PLAY_ENDED:Lcom/adobe/ave/ListenerType;

    .line 91
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "DRM_ERROR"

    const/16 v2, 0xd

    const/16 v3, 0x2000

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->DRM_ERROR:Lcom/adobe/ave/ListenerType;

    .line 96
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "BACKGROUND_MANIFEST_ERROR"

    const/16 v2, 0xe

    const/16 v3, 0x4000

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_ERROR:Lcom/adobe/ave/ListenerType;

    .line 101
    new-instance v0, Lcom/adobe/ave/ListenerType;

    const-string v1, "BACKGROUND_MANIFEST_WARNING"

    const/16 v2, 0xf

    const v3, 0x8000

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/ListenerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_WARNING:Lcom/adobe/ave/ListenerType;

    .line 24
    const/16 v0, 0x10

    new-array v0, v0, [Lcom/adobe/ave/ListenerType;

    sget-object v1, Lcom/adobe/ave/ListenerType;->ERROR:Lcom/adobe/ave/ListenerType;

    aput-object v1, v0, v8

    sget-object v1, Lcom/adobe/ave/ListenerType;->PLAY_STATE:Lcom/adobe/ave/ListenerType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/ave/ListenerType;->STREAM_SWITCH:Lcom/adobe/ave/ListenerType;

    aput-object v1, v0, v5

    const/4 v1, 0x3

    sget-object v2, Lcom/adobe/ave/ListenerType;->STREAM_METADATA:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    sget-object v1, Lcom/adobe/ave/ListenerType;->DRM_METADATA:Lcom/adobe/ave/ListenerType;

    aput-object v1, v0, v6

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/ave/ListenerType;->TIMELINE:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/ave/ListenerType;->DATA:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/ave/ListenerType;->MANIFEST_LOAD:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    sget-object v1, Lcom/adobe/ave/ListenerType;->SEEK_COMPLETE:Lcom/adobe/ave/ListenerType;

    aput-object v1, v0, v7

    const/16 v1, 0x9

    sget-object v2, Lcom/adobe/ave/ListenerType;->WARNING:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/adobe/ave/ListenerType;->DICTIONARY_DATA:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/adobe/ave/ListenerType;->LOAD_INFO:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/adobe/ave/ListenerType;->TRICK_PLAY_ENDED:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/adobe/ave/ListenerType;->DRM_ERROR:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_ERROR:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/adobe/ave/ListenerType;->BACKGROUND_MANIFEST_WARNING:Lcom/adobe/ave/ListenerType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/ave/ListenerType;->$VALUES:[Lcom/adobe/ave/ListenerType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "value"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 106
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 107
    iput p3, p0, Lcom/adobe/ave/ListenerType;->value:I

    .line 108
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/ListenerType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 24
    const-class v0, Lcom/adobe/ave/ListenerType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/ListenerType;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/ListenerType;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/adobe/ave/ListenerType;->$VALUES:[Lcom/adobe/ave/ListenerType;

    invoke-virtual {v0}, [Lcom/adobe/ave/ListenerType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/ListenerType;

    return-object v0
.end method


# virtual methods
.method final getValue()I
    .locals 1

    .prologue
    .line 111
    iget v0, p0, Lcom/adobe/ave/ListenerType;->value:I

    return v0
.end method
