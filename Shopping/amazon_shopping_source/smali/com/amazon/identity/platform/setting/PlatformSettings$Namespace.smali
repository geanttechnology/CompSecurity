.class public final enum Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;
.super Ljava/lang/Enum;
.source "PlatformSettings.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/platform/setting/PlatformSettings;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Namespace"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

.field public static final enum Default:Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

.field public static final enum DeviceGlobal:Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 12
    new-instance v0, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    const-string/jumbo v1, "DeviceGlobal"

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;->DeviceGlobal:Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    .line 14
    new-instance v0, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    const-string/jumbo v1, "Default"

    invoke-direct {v0, v1, v3}, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;->Default:Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    .line 10
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    sget-object v1, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;->DeviceGlobal:Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;->Default:Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;->$VALUES:[Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

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
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    return-object v0
.end method

.method public static values()[Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;->$VALUES:[Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    invoke-virtual {v0}, [Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    return-object v0
.end method
