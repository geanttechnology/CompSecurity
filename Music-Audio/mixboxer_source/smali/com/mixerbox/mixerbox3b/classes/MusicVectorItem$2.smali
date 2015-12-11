.class Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)V
    .locals 0

    .prologue
    .line 150
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    .line 153
    const-string v8, ""

    .line 154
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->id:Ljava/lang/String;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->access$100(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tt:Ljava/lang/String;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->access$200(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tm:Ljava/lang/String;
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->access$300(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->f:Ljava/lang/String;
    invoke-static {v4}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->access$400(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->position:I
    invoke-static {v5}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->access$500(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)I

    move-result v5

    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->source:I
    invoke-static {v6}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->access$600(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)I

    move-result v6

    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->thumb:Ljava/lang/String;
    invoke-static {v7}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->access$700(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v7}, Lcom/mixerbox/mixerbox3b/classes/SongItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V

    .line 156
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->access$800(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->k:I
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->access$900(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)I

    move-result v2

    invoke-static {v1, p1, v0, v8, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->createPopupMenu(Landroid/content/Context;Landroid/view/View;Lcom/mixerbox/mixerbox3b/classes/SongItem;Ljava/lang/String;I)V

    .line 157
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 158
    const-string v1, "id"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;->this$0:Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;

    # getter for: Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->id:Ljava/lang/String;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->access$100(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 159
    const-string v1, "playlist"

    invoke-interface {v0, v1, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 160
    const-string v1, "action:music_edit"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 161
    return-void
.end method
