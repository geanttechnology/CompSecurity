.class Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;
.super Lco/vine/android/client/AppSessionListener;
.source "ExploreChannelsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ExploreChannelsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ExploreChannelsAppSessionListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ExploreChannelsActivity;


# direct methods
.method constructor <init>(Lco/vine/android/ExploreChannelsActivity;)V
    .locals 0

    .prologue
    .line 324
    iput-object p1, p0, Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;->this$0:Lco/vine/android/ExploreChannelsActivity;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onGetChannelsComplete(Ljava/lang/String;ILjava/lang/String;Ljava/util/ArrayList;)V
    .locals 7
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineChannel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 338
    .local p4, "channels":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineChannel;>;"
    const/16 v5, 0xc8

    if-ne p2, v5, :cond_2

    iget-object v5, p0, Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;->this$0:Lco/vine/android/ExploreChannelsActivity;

    # getter for: Lco/vine/android/ExploreChannelsActivity;->mChannelId:Ljava/lang/String;
    invoke-static {v5}, Lco/vine/android/ExploreChannelsActivity;->access$200(Lco/vine/android/ExploreChannelsActivity;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 339
    iget-object v5, p0, Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;->this$0:Lco/vine/android/ExploreChannelsActivity;

    # getter for: Lco/vine/android/ExploreChannelsActivity;->mChannelId:Ljava/lang/String;
    invoke-static {v5}, Lco/vine/android/ExploreChannelsActivity;->access$200(Lco/vine/android/ExploreChannelsActivity;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    .line 340
    .local v1, "channelId":J
    invoke-virtual {p4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineChannel;

    .line 341
    .local v0, "channel":Lco/vine/android/api/VineChannel;
    iget-wide v5, v0, Lco/vine/android/api/VineChannel;->channelId:J

    cmp-long v5, v1, v5

    if-nez v5, :cond_0

    .line 342
    iget-object v5, p0, Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;->this$0:Lco/vine/android/ExploreChannelsActivity;

    invoke-static {v5}, Lco/vine/android/util/Util;->isHighRes(Landroid/content/Context;)Z

    move-result v4

    .line 343
    .local v4, "isHighRes":Z
    iget-object v6, p0, Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;->this$0:Lco/vine/android/ExploreChannelsActivity;

    if-eqz v4, :cond_1

    iget-object v5, v0, Lco/vine/android/api/VineChannel;->retinaIconFullUrl:Ljava/lang/String;

    :goto_1
    # invokes: Lco/vine/android/ExploreChannelsActivity;->setIconImage(Ljava/lang/String;)V
    invoke-static {v6, v5}, Lco/vine/android/ExploreChannelsActivity;->access$300(Lco/vine/android/ExploreChannelsActivity;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    iget-object v5, v0, Lco/vine/android/api/VineChannel;->iconFullUrl:Ljava/lang/String;

    goto :goto_1

    .line 347
    .end local v0    # "channel":Lco/vine/android/api/VineChannel;
    .end local v1    # "channelId":J
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "isHighRes":Z
    :cond_2
    return-void
.end method

.method public onPhotoImageLoaded(Ljava/util/HashMap;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 327
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    invoke-virtual {p1}, Ljava/util/HashMap;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;->this$0:Lco/vine/android/ExploreChannelsActivity;

    # getter for: Lco/vine/android/ExploreChannelsActivity;->mIconImageKey:Lco/vine/android/util/image/ImageKey;
    invoke-static {v1}, Lco/vine/android/ExploreChannelsActivity;->access$000(Lco/vine/android/ExploreChannelsActivity;)Lco/vine/android/util/image/ImageKey;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 328
    iget-object v1, p0, Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;->this$0:Lco/vine/android/ExploreChannelsActivity;

    # getter for: Lco/vine/android/ExploreChannelsActivity;->mIconImageKey:Lco/vine/android/util/image/ImageKey;
    invoke-static {v1}, Lco/vine/android/ExploreChannelsActivity;->access$000(Lco/vine/android/ExploreChannelsActivity;)Lco/vine/android/util/image/ImageKey;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/image/UrlImage;

    .line 329
    .local v0, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, v0, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_0

    .line 330
    iget-object v1, p0, Lco/vine/android/ExploreChannelsActivity$ExploreChannelsAppSessionListener;->this$0:Lco/vine/android/ExploreChannelsActivity;

    iget-object v2, v0, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    # invokes: Lco/vine/android/ExploreChannelsActivity;->setIconImage(Landroid/graphics/Bitmap;)V
    invoke-static {v1, v2}, Lco/vine/android/ExploreChannelsActivity;->access$100(Lco/vine/android/ExploreChannelsActivity;Landroid/graphics/Bitmap;)V

    .line 333
    .end local v0    # "image":Lco/vine/android/util/image/UrlImage;
    :cond_0
    return-void
.end method
