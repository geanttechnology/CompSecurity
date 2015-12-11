.class public final enum Lcom/adobe/ave/DataType;
.super Ljava/lang/Enum;
.source "DataType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/ave/DataType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/ave/DataType;

.field public static final enum DT_3GPP_CAPTION_METADATA:Lcom/adobe/ave/DataType;

.field public static final enum DT_AMF:Lcom/adobe/ave/DataType;


# instance fields
.field private final value:I


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 30
    new-instance v0, Lcom/adobe/ave/DataType;

    const-string v1, "DT_3GPP_CAPTION_METADATA"

    const v2, 0x33475050

    invoke-direct {v0, v1, v3, v2}, Lcom/adobe/ave/DataType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/DataType;->DT_3GPP_CAPTION_METADATA:Lcom/adobe/ave/DataType;

    .line 35
    new-instance v0, Lcom/adobe/ave/DataType;

    const-string v1, "DT_AMF"

    const v2, 0x414d462e

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/ave/DataType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/adobe/ave/DataType;->DT_AMF:Lcom/adobe/ave/DataType;

    .line 25
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/adobe/ave/DataType;

    sget-object v1, Lcom/adobe/ave/DataType;->DT_3GPP_CAPTION_METADATA:Lcom/adobe/ave/DataType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/ave/DataType;->DT_AMF:Lcom/adobe/ave/DataType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/adobe/ave/DataType;->$VALUES:[Lcom/adobe/ave/DataType;

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
    .line 39
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 40
    iput p3, p0, Lcom/adobe/ave/DataType;->value:I

    .line 41
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/ave/DataType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 25
    const-class v0, Lcom/adobe/ave/DataType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/ave/DataType;

    return-object v0
.end method

.method public static values()[Lcom/adobe/ave/DataType;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/adobe/ave/DataType;->$VALUES:[Lcom/adobe/ave/DataType;

    invoke-virtual {v0}, [Lcom/adobe/ave/DataType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/ave/DataType;

    return-object v0
.end method


# virtual methods
.method final getValue()I
    .locals 1

    .prologue
    .line 44
    iget v0, p0, Lcom/adobe/ave/DataType;->value:I

    return v0
.end method
