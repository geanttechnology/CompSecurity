.class final enum Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;
.super Ljava/lang/Enum;
.source "WrappableHttpURLConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "ConnectionState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

.field public static final enum Connected:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

.field public static final enum Connecting:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

.field public static final enum Initial:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 26
    new-instance v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    const-string/jumbo v1, "Initial"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->Initial:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    .line 27
    new-instance v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    const-string/jumbo v1, "Connecting"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->Connecting:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    .line 28
    new-instance v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    const-string/jumbo v1, "Connected"

    invoke-direct {v0, v1, v4}, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->Connected:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    .line 24
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->Initial:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->Connecting:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->Connected:Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->$VALUES:[Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 24
    const-class v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;
    .locals 1

    .prologue
    .line 24
    sget-object v0, Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->$VALUES:[Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    invoke-virtual {v0}, [Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/auth/device/framework/WrappableHttpURLConnection$ConnectionState;

    return-object v0
.end method
