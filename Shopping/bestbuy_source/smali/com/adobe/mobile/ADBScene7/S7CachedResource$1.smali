.class Lcom/adobe/mobile/ADBScene7/S7CachedResource$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/ADBScene7/S7CachedResource;->GetS7CachedResource(Ljava/lang/String;Lcom/adobe/mobile/ADBScene7/S7ResourceType;IILjava/lang/String;Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;)V
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mobile/ADBScene7/S7CachedResource;

.field final synthetic val$callback:Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;


# direct methods
.method constructor <init>(Lcom/adobe/mobile/ADBScene7/S7CachedResource;Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;)V
    .locals 0

    .prologue
    .line 22
    iput-object p1, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$1;->this$0:Lcom/adobe/mobile/ADBScene7/S7CachedResource;

    iput-object p2, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$1;->val$callback:Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call(Landroid/graphics/Bitmap;)V
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$1;->val$callback:Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;

    if-eqz v0, :cond_0

    .line 26
    iget-object v0, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$1;->val$callback:Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;

    invoke-interface {v0, p1}, Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;->call(Ljava/lang/Object;)V

    .line 28
    :cond_0
    return-void
.end method

.method public bridge synthetic call(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 22
    check-cast p1, Landroid/graphics/Bitmap;

    invoke-virtual {p0, p1}, Lcom/adobe/mobile/ADBScene7/S7CachedResource$1;->call(Landroid/graphics/Bitmap;)V

    return-void
.end method
