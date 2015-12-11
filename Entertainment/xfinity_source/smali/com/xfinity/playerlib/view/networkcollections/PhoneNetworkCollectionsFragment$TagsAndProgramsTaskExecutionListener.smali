.class Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "PhoneNetworkCollectionsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TagsAndProgramsTaskExecutionListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)V
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$1;

    .prologue
    .line 212
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 3
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 274
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$1400(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v1

    new-instance v2, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$3;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$3;-><init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;)V

    invoke-virtual {v1, p1, v2}, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->createErrorDialogForThrowable(Ljava/lang/Throwable;Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    .line 281
    .local v0, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "caldialogfragment"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 282
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 217
    iget-object v3, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v3, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 218
    .local v3, "tagsRoot":Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 220
    .local v0, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->companyId:J
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$200(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)J

    move-result-wide v4

    invoke-interface {v3, v4, v5}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworkByCompanyId(J)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v2

    .line 224
    .local v2, "network":Lcom/xfinity/playerlib/model/tags/Network;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$300(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 225
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$300(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    move-result-object v4

    invoke-interface {v4, v2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;->loadNetworkLogo(Lcom/xfinity/playerlib/model/tags/Network;)V

    .line 228
    :cond_0
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/Network;->getFeaturedShow()Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    move-result-object v1

    .line 230
    .local v1, "featuredShow":Lcom/xfinity/playerlib/model/tags/FeaturedShow;
    if-eqz v1, :cond_1

    .line 231
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->detailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$600(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureImage:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$400(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/ImageView;

    move-result-object v5

    new-instance v6, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$1;

    invoke-direct {v6, p0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$1;-><init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;)V

    invoke-virtual {v4, v1, v5, v6}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->loadNetworkFeatureDetailProgramArt(Lcom/xfinity/playerlib/model/tags/FeaturedShow;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    .line 242
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureSection:Landroid/widget/LinearLayout;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/LinearLayout;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # invokes: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getOnClickListenerForProgramDetail(Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnClickListener;
    invoke-static {v5, v1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$700(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnClickListener;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 243
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureSection:Landroid/widget/LinearLayout;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/LinearLayout;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # invokes: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getOnLongClickListenerForProgramDetail(Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnLongClickListener;
    invoke-static {v5, v1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$800(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnLongClickListener;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 245
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureTitle:Landroid/widget/TextView;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$900(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/TextView;

    move-result-object v4

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 246
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureTitle:Landroid/widget/TextView;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$900(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/TextView;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    sget v6, Lcom/xfinity/playerlib/R$string;->content_description_feature_program:I

    new-array v7, v11, [Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->getTitle()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v10

    invoke-virtual {v5, v6, v7}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 252
    :goto_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->categoryAdapter:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$1000(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;

    move-result-object v4

    invoke-virtual {v4, v2, v0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$CategoryAdapter;->setData(Lcom/xfinity/playerlib/model/tags/Network;Lcom/xfinity/playerlib/model/dibic/DibicResource;)V

    .line 254
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->categoryList:Landroid/widget/ListView;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$1200(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/ListView;

    move-result-object v4

    new-instance v5, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$2;

    invoke-direct {v5, p0, v2}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$2;-><init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;Lcom/xfinity/playerlib/model/tags/Network;)V

    invoke-virtual {v4, v5}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 267
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->categoryList:Landroid/widget/ListView;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$1200(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/ListView;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    sget v6, Lcom/xfinity/playerlib/R$string;->content_description_network_categories_main:I

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    iget-object v8, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->companyId:J
    invoke-static {v8}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$200(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v7, v10

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/Network;->getCategories()Ljava/util/List;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-virtual {v5, v6, v7}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ListView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 269
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->hideLoading()V

    .line 270
    return-void

    .line 249
    :cond_1
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->featureSection:Landroid/widget/LinearLayout;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)Landroid/widget/LinearLayout;

    move-result-object v4

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 212
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V

    return-void
.end method
