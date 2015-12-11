.class public final enum Lcom/amazon/dcp/settings/SettingsNamespace;
.super Ljava/lang/Enum;
.source "SettingsNamespace.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/dcp/settings/SettingsNamespace;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/dcp/settings/SettingsNamespace;

.field public static final enum AppLocal:Lcom/amazon/dcp/settings/SettingsNamespace;

.field public static final enum Default:Lcom/amazon/dcp/settings/SettingsNamespace;

.field public static final enum DeviceGlobal:Lcom/amazon/dcp/settings/SettingsNamespace;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 6
    new-instance v0, Lcom/amazon/dcp/settings/SettingsNamespace;

    const-string/jumbo v1, "Default"

    invoke-direct {v0, v1, v2}, Lcom/amazon/dcp/settings/SettingsNamespace;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dcp/settings/SettingsNamespace;->Default:Lcom/amazon/dcp/settings/SettingsNamespace;

    .line 7
    new-instance v0, Lcom/amazon/dcp/settings/SettingsNamespace;

    const-string/jumbo v1, "AppLocal"

    invoke-direct {v0, v1, v3}, Lcom/amazon/dcp/settings/SettingsNamespace;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dcp/settings/SettingsNamespace;->AppLocal:Lcom/amazon/dcp/settings/SettingsNamespace;

    .line 8
    new-instance v0, Lcom/amazon/dcp/settings/SettingsNamespace;

    const-string/jumbo v1, "DeviceGlobal"

    invoke-direct {v0, v1, v4}, Lcom/amazon/dcp/settings/SettingsNamespace;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/dcp/settings/SettingsNamespace;->DeviceGlobal:Lcom/amazon/dcp/settings/SettingsNamespace;

    .line 4
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/dcp/settings/SettingsNamespace;

    sget-object v1, Lcom/amazon/dcp/settings/SettingsNamespace;->Default:Lcom/amazon/dcp/settings/SettingsNamespace;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/dcp/settings/SettingsNamespace;->AppLocal:Lcom/amazon/dcp/settings/SettingsNamespace;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/dcp/settings/SettingsNamespace;->DeviceGlobal:Lcom/amazon/dcp/settings/SettingsNamespace;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/dcp/settings/SettingsNamespace;->$VALUES:[Lcom/amazon/dcp/settings/SettingsNamespace;

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
    .line 11
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 12
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/dcp/settings/SettingsNamespace;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 4
    const-class v0, Lcom/amazon/dcp/settings/SettingsNamespace;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/dcp/settings/SettingsNamespace;

    return-object v0
.end method

.method public static values()[Lcom/amazon/dcp/settings/SettingsNamespace;
    .locals 1

    .prologue
    .line 4
    sget-object v0, Lcom/amazon/dcp/settings/SettingsNamespace;->$VALUES:[Lcom/amazon/dcp/settings/SettingsNamespace;

    invoke-virtual {v0}, [Lcom/amazon/dcp/settings/SettingsNamespace;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/dcp/settings/SettingsNamespace;

    return-object v0
.end method
