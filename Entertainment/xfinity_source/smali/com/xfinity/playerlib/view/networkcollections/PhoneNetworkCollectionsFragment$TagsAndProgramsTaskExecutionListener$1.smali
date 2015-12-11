.class Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$1;
.super Ljava/lang/Object;
.source "PhoneNetworkCollectionsFragment.java"

# interfaces
.implements Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    .prologue
    .line 231
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$1;->this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoad(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;
    .param p3, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 234
    return-void
.end method

.method public onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V
    .locals 2
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 238
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$1;->this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureSection:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 239
    return-void
.end method
