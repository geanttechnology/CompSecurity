.class public Lco/vine/android/ConversationAdapter$ConversationVideoClickedListener;
.super Lco/vine/android/player/OnListVideoClickListener;
.source "ConversationAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ConversationAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ConversationVideoClickedListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationAdapter;


# direct methods
.method public constructor <init>(Lco/vine/android/ConversationAdapter;)V
    .locals 0

    .prologue
    .line 1338
    iput-object p1, p0, Lco/vine/android/ConversationAdapter$ConversationVideoClickedListener;->this$0:Lco/vine/android/ConversationAdapter;

    .line 1339
    invoke-direct {p0, p1}, Lco/vine/android/player/OnListVideoClickListener;-><init>(Lco/vine/android/player/HasVideoPlayerAdapter;)V

    .line 1340
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1344
    invoke-super {p0, p1}, Lco/vine/android/player/OnListVideoClickListener;->onClick(Landroid/view/View;)V

    .line 1345
    iget-object v0, p0, Lco/vine/android/ConversationAdapter$ConversationVideoClickedListener;->this$0:Lco/vine/android/ConversationAdapter;

    const/4 v1, -0x1

    # setter for: Lco/vine/android/ConversationAdapter;->mSingleLoopPosition:I
    invoke-static {v0, v1}, Lco/vine/android/ConversationAdapter;->access$802(Lco/vine/android/ConversationAdapter;I)I

    .line 1346
    return-void
.end method
