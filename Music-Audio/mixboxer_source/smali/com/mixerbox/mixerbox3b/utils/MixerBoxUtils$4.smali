.class final Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic val$ctx:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 296
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$4;->val$ctx:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils$4;->val$ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setLocalNotificationList()V

    .line 300
    return-void
.end method
