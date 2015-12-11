.class public final enum Lcom/adobe/ave/AudioCodecs;
.super Ljava/lang/Enum;
.source "AudioCodecs.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/AudioCodecs;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/AudioCodecs;

.field public static final enum AAC:Lcom/adobe/ave/AudioCodecs;

.field public static final enum AC3:Lcom/adobe/ave/AudioCodecs;

.field public static final enum ADPCM:Lcom/adobe/ave/AudioCodecs;

.field public static final enum DTS:Lcom/adobe/ave/AudioCodecs;

.field public static final enum DTS_EXPRESS:Lcom/adobe/ave/AudioCodecs;

.field public static final enum DTS_HD_HR:Lcom/adobe/ave/AudioCodecs;

.field public static final enum DTS_HD_MA:Lcom/adobe/ave/AudioCodecs;

.field public static final enum EAC3:Lcom/adobe/ave/AudioCodecs;

.field public static final enum G711A:Lcom/adobe/ave/AudioCodecs;

.field public static final enum G711U:Lcom/adobe/ave/AudioCodecs;

.field public static final enum INVALID:Lcom/adobe/ave/AudioCodecs;

.field public static final enum MAX_AUDIO_CODECS:Lcom/adobe/ave/AudioCodecs;

.field public static final enum MP3:Lcom/adobe/ave/AudioCodecs;

.field public static final enum NELLY_MOSER:Lcom/adobe/ave/AudioCodecs;

.field public static final enum NELLY_MOSER16:Lcom/adobe/ave/AudioCodecs;

.field public static final enum NELLY_MOSER8:Lcom/adobe/ave/AudioCodecs;

.field public static final enum NO_AUDIO:Lcom/adobe/ave/AudioCodecs;

.field public static final enum PCMBE:Lcom/adobe/ave/AudioCodecs;

.field public static final enum PCMLE:Lcom/adobe/ave/AudioCodecs;

.field public static final enum SPEEX:Lcom/adobe/ave/AudioCodecs;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 29
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "INVALID"

    invoke-direct {v0, v1, v4, v4}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->INVALID:Lcom/adobe/ave/AudioCodecs;

    .line 34
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "NO_AUDIO"

    invoke-direct {v0, v1, v5, v5}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->NO_AUDIO:Lcom/adobe/ave/AudioCodecs;

    .line 39
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "PCMLE"

    invoke-direct {v0, v1, v6, v6}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->PCMLE:Lcom/adobe/ave/AudioCodecs;

    .line 44
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "PCMBE"

    invoke-direct {v0, v1, v7, v7}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->PCMBE:Lcom/adobe/ave/AudioCodecs;

    .line 49
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "ADPCM"

    invoke-direct {v0, v1, v8, v8}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->ADPCM:Lcom/adobe/ave/AudioCodecs;

    .line 54
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "MP3"

    const/4 v2, 0x5

    const/4 v3, 0x5

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->MP3:Lcom/adobe/ave/AudioCodecs;

    .line 59
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "NELLY_MOSER16"

    const/4 v2, 0x6

    const/4 v3, 0x6

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->NELLY_MOSER16:Lcom/adobe/ave/AudioCodecs;

    .line 64
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "NELLY_MOSER8"

    const/4 v2, 0x7

    const/4 v3, 0x7

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->NELLY_MOSER8:Lcom/adobe/ave/AudioCodecs;

    .line 69
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "NELLY_MOSER"

    const/16 v2, 0x8

    const/16 v3, 0x8

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->NELLY_MOSER:Lcom/adobe/ave/AudioCodecs;

    .line 74
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "G711A"

    const/16 v2, 0x9

    const/16 v3, 0x9

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->G711A:Lcom/adobe/ave/AudioCodecs;

    .line 79
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "G711U"

    const/16 v2, 0xa

    const/16 v3, 0xa

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->G711U:Lcom/adobe/ave/AudioCodecs;

    .line 84
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "AAC"

    const/16 v2, 0xb

    const/16 v3, 0xb

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->AAC:Lcom/adobe/ave/AudioCodecs;

    .line 89
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "SPEEX"

    const/16 v2, 0xc

    const/16 v3, 0xc

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->SPEEX:Lcom/adobe/ave/AudioCodecs;

    .line 94
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "AC3"

    const/16 v2, 0xd

    const/16 v3, 0xd

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->AC3:Lcom/adobe/ave/AudioCodecs;

    .line 99
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "EAC3"

    const/16 v2, 0xe

    const/16 v3, 0xe

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->EAC3:Lcom/adobe/ave/AudioCodecs;

    .line 104
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "DTS"

    const/16 v2, 0xf

    const/16 v3, 0xf

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->DTS:Lcom/adobe/ave/AudioCodecs;

    .line 109
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "DTS_EXPRESS"

    const/16 v2, 0x10

    const/16 v3, 0x10

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->DTS_EXPRESS:Lcom/adobe/ave/AudioCodecs;

    .line 114
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "DTS_HD_HR"

    const/16 v2, 0x11

    const/16 v3, 0x11

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->DTS_HD_HR:Lcom/adobe/ave/AudioCodecs;

    .line 119
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "DTS_HD_MA"

    const/16 v2, 0x12

    const/16 v3, 0x12

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->DTS_HD_MA:Lcom/adobe/ave/AudioCodecs;

    .line 124
    new-instance v0, Lcom/adobe/ave/AudioCodecs;

    const-string v1, "MAX_AUDIO_CODECS"

    const/16 v2, 0x13

    const/16 v3, 0x13

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/ave/AudioCodecs;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->MAX_AUDIO_CODECS:Lcom/adobe/ave/AudioCodecs;

    .line 24
    const/16 v0, 0x14

    new-array v0, v0, [Lcom/adobe/ave/AudioCodecs;

    sget-object v1, Lcom/adobe/ave/AudioCodecs;->INVALID:Lcom/adobe/ave/AudioCodecs;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/ave/AudioCodecs;->NO_AUDIO:Lcom/adobe/ave/AudioCodecs;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/ave/AudioCodecs;->PCMLE:Lcom/adobe/ave/AudioCodecs;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/ave/AudioCodecs;->PCMBE:Lcom/adobe/ave/AudioCodecs;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/ave/AudioCodecs;->ADPCM:Lcom/adobe/ave/AudioCodecs;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->MP3:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->NELLY_MOSER16:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->NELLY_MOSER8:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->NELLY_MOSER:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->G711A:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->G711U:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->AAC:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->SPEEX:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->AC3:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->EAC3:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->DTS:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->DTS_EXPRESS:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->DTS_HD_HR:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->DTS_HD_MA:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/adobe/ave/AudioCodecs;->MAX_AUDIO_CODECS:Lcom/adobe/ave/AudioCodecs;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/ave/AudioCodecs;->$VALUES:[Lcom/adobe/ave/AudioCodecs;

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
    .line 128
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 129
    iput p3, p0, Lcom/adobe/ave/AudioCodecs;->value:I

    .line 130
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/AudioCodecs;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 24
    const-class v0, Lcom/adobe/ave/AudioCodecs;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/AudioCodecs;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/AudioCodecs;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/adobe/ave/AudioCodecs;->$VALUES:[Lcom/adobe/ave/AudioCodecs;

    invoke-virtual {v0}, [Lcom/adobe/ave/AudioCodecs;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/AudioCodecs;

    return-object v0
.end method


# virtual methods
.method final getValue()I
    .locals 1

    .prologue
    .line 133
    iget v0, p0, Lcom/adobe/ave/AudioCodecs;->value:I

    return v0
.end method
