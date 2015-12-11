.class public Lcom/amazon/mShop/voice/VoiceSearchInitializer$KeyboardListener;
.super Ljava/lang/Object;
.source "VoiceSearchInitializer.java"

# interfaces
.implements Lcom/amazon/shopapp/voice/module/KeyboardModeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/voice/VoiceSearchInitializer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "KeyboardListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/voice/VoiceSearchInitializer;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/voice/VoiceSearchInitializer;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/amazon/mShop/voice/VoiceSearchInitializer$KeyboardListener;->this$0:Lcom/amazon/mShop/voice/VoiceSearchInitializer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public search(Landroid/app/Activity;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 139
    :try_start_0
    instance-of v1, p1, Lcom/amazon/mShop/AmazonActivity;

    if-nez v1, :cond_0

    .line 147
    .end local p1    # "activity":Landroid/app/Activity;
    :goto_0
    return-void

    .line 143
    .restart local p1    # "activity":Landroid/app/Activity;
    :cond_0
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "activity":Landroid/app/Activity;
    invoke-virtual {p1}, Lcom/amazon/mShop/AmazonActivity;->onSearchRequested()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 144
    :catch_0
    move-exception v0

    .line 145
    .local v0, "e":Ljava/lang/Exception;
    # getter for: Lcom/amazon/mShop/voice/VoiceSearchInitializer;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/voice/VoiceSearchInitializer;->access$000()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Failed to open search"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
