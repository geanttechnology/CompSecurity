.class Lco/vine/android/util/ConversationMenuHelper$1;
.super Ljava/lang/Object;
.source "ConversationMenuHelper.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/util/ConversationMenuHelper;->setupConversationSlidingMenu()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/util/ConversationMenuHelper;


# direct methods
.method constructor <init>(Lco/vine/android/util/ConversationMenuHelper;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lco/vine/android/util/ConversationMenuHelper$1;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 101
    iget-object v0, p0, Lco/vine/android/util/ConversationMenuHelper$1;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/util/ConversationMenuHelper;->toggleContactSearch(Z)V

    .line 102
    return-void
.end method
