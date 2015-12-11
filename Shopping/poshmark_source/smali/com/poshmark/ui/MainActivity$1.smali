.class Lcom/poshmark/ui/MainActivity$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/MainActivity;->fireBeacons()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/MainActivity;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/MainActivity;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 354
    iput-object p1, p0, Lcom/poshmark/ui/MainActivity$1;->this$0:Lcom/poshmark/ui/MainActivity;

    iput-object p2, p0, Lcom/poshmark/ui/MainActivity$1;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 358
    iget-object v0, p0, Lcom/poshmark/ui/MainActivity$1;->val$context:Landroid/content/Context;

    iget-object v1, p0, Lcom/poshmark/ui/MainActivity$1;->this$0:Lcom/poshmark/ui/MainActivity;

    invoke-virtual {v1}, Lcom/poshmark/ui/MainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06010b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/facebook/appevents/AppEventsLogger;->activateApp(Landroid/content/Context;Ljava/lang/String;)V

    .line 359
    return-void
.end method
