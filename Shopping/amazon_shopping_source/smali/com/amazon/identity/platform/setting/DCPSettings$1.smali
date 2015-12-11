.class Lcom/amazon/identity/platform/setting/DCPSettings$1;
.super Ljava/lang/Object;
.source "DCPSettings.java"

# interfaces
.implements Lcom/amazon/dcp/settings/SettingsCache$IListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/platform/setting/DCPSettings;->addListener(Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/platform/setting/DCPSettings;

.field final synthetic val$listener:Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;


# direct methods
.method constructor <init>(Lcom/amazon/identity/platform/setting/DCPSettings;Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;)V
    .locals 0

    .prologue
    .line 103
    iput-object p1, p0, Lcom/amazon/identity/platform/setting/DCPSettings$1;->this$0:Lcom/amazon/identity/platform/setting/DCPSettings;

    iput-object p2, p0, Lcom/amazon/identity/platform/setting/DCPSettings$1;->val$listener:Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCacheUpdated()V
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/identity/platform/setting/DCPSettings$1;->val$listener:Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;

    invoke-interface {v0}, Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;->onCacheUpdated()V

    .line 109
    return-void
.end method
