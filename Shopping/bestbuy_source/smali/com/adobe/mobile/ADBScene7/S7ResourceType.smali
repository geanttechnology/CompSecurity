.class public final enum Lcom/adobe/mobile/ADBScene7/S7ResourceType;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mobile/ADBScene7/S7ResourceType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mobile/ADBScene7/S7ResourceType;

.field public static final enum S7ResourceTypeContent:Lcom/adobe/mobile/ADBScene7/S7ResourceType;

.field public static final enum S7ResourceTypeImage:Lcom/adobe/mobile/ADBScene7/S7ResourceType;


# instance fields
.field private resourceType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 4
    new-instance v0, Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    const-string v1, "S7ResourceTypeImage"

    const-string v2, "image"

    invoke-direct {v0, v1, v3, v2}, Lcom/adobe/mobile/ADBScene7/S7ResourceType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mobile/ADBScene7/S7ResourceType;->S7ResourceTypeImage:Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    .line 5
    new-instance v0, Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    const-string v1, "S7ResourceTypeContent"

    const-string v2, "content"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mobile/ADBScene7/S7ResourceType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mobile/ADBScene7/S7ResourceType;->S7ResourceTypeContent:Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    .line 3
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    sget-object v1, Lcom/adobe/mobile/ADBScene7/S7ResourceType;->S7ResourceTypeImage:Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mobile/ADBScene7/S7ResourceType;->S7ResourceTypeContent:Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/adobe/mobile/ADBScene7/S7ResourceType;->$VALUES:[Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 9
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 10
    iput-object p3, p0, Lcom/adobe/mobile/ADBScene7/S7ResourceType;->resourceType:Ljava/lang/String;

    .line 11
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mobile/ADBScene7/S7ResourceType;
    .locals 1

    .prologue
    .line 3
    const-class v0, Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mobile/ADBScene7/S7ResourceType;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/adobe/mobile/ADBScene7/S7ResourceType;->$VALUES:[Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    invoke-virtual {v0}, [Lcom/adobe/mobile/ADBScene7/S7ResourceType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mobile/ADBScene7/S7ResourceType;

    return-object v0
.end method


# virtual methods
.method public getTypeName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lcom/adobe/mobile/ADBScene7/S7ResourceType;->resourceType:Ljava/lang/String;

    return-object v0
.end method
