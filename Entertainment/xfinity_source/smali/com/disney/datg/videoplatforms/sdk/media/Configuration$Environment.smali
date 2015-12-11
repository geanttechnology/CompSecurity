.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;
.super Ljava/lang/Enum;
.source "Configuration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Environment"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

.field public static final enum PRODUCTION:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

.field public static final enum QA:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;


# instance fields
.field configService:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 116
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    const-string v1, "QA"

    const-string v2, "http://api.abc.com/vp2/watch/v4/config/%BRAND%/%PARTNER%/?ak=%APIKEY%"

    invoke-direct {v0, v1, v3, v2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->QA:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    .line 117
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    const-string v1, "PRODUCTION"

    const-string v2, "http://api.abc.com/vp2/watch/v4/config/%BRAND%/%PARTNER%/?ak=%APIKEY%"

    invoke-direct {v0, v1, v4, v2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->PRODUCTION:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    .line 114
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->QA:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->PRODUCTION:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    aput-object v1, v0, v4

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "service"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 121
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 122
    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->configService:Ljava/lang/String;

    .line 123
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 114
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;
    .locals 1

    .prologue
    .line 114
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    return-object v0
.end method


# virtual methods
.method public getService()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->configService:Ljava/lang/String;

    return-object v0
.end method
