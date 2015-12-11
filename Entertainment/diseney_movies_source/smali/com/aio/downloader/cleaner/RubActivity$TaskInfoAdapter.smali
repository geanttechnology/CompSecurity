.class Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;
.super Landroid/widget/BaseAdapter;
.source "RubActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/RubActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TaskInfoAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/RubActivity;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 4

    .prologue
    .line 852
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 854
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-static {p1, v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$17(Lcom/aio/downloader/cleaner/RubActivity;Ljava/util/List;)V

    .line 856
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-static {p1, v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$18(Lcom/aio/downloader/cleaner/RubActivity;Ljava/util/List;)V

    .line 858
    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->taskInfos:Ljava/util/List;
    invoke-static {p1}, Lcom/aio/downloader/cleaner/RubActivity;->access$19(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 870
    return-void

    .line 858
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/cleaner/TaskInfo;

    .line 859
    .local v0, "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->isSystemProcess()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 860
    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->systemTaskInfos:Ljava/util/List;
    invoke-static {p1}, Lcom/aio/downloader/cleaner/RubActivity;->access$20(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 861
    :cond_2
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Google"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 862
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->getPackageName()Ljava/lang/String;

    move-result-object v2

    .line 863
    const-string v3, "com.allinone.free"

    .line 862
    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    .line 863
    if-nez v2, :cond_0

    .line 864
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "google"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 865
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "google"

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 866
    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {p1}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private newTextView(Ljava/lang/String;)Landroid/widget/TextView;
    .locals 2
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 979
    new-instance v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 980
    .local v0, "tv_title":Landroid/widget/TextView;
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 981
    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 4

    .prologue
    .line 874
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->sp:Landroid/content/SharedPreferences;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$22(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "showSystemProcess"

    .line 875
    const/4 v3, 0x0

    .line 874
    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 876
    .local v0, "showSystemProcess":Z
    if-eqz v0, :cond_0

    .line 878
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->taskInfos:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$19(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, 0x2

    .line 880
    :goto_0
    return v1

    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 886
    if-nez p1, :cond_0

    .line 887
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 896
    :goto_0
    return-object v0

    .line 888
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-gt p1, v0, :cond_1

    .line 889
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v0

    add-int/lit8 v1, p1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 890
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    if-ne p1, v0, :cond_2

    .line 891
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_0

    .line 892
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->taskInfos:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$19(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, 0x2

    if-gt p1, v0, :cond_3

    .line 894
    iget-object v0, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->systemTaskInfos:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/RubActivity;->access$20(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    sub-int v1, p1, v1

    add-int/lit8 v1, v1, -0x2

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 896
    :cond_3
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 902
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v6, 0x0

    .line 911
    if-nez p1, :cond_0

    .line 913
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "  User Process("

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 914
    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 913
    invoke-direct {p0, v4}, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->newTextView(Ljava/lang/String;)Landroid/widget/TextView;

    move-result-object v2

    .line 975
    :goto_0
    return-object v2

    .line 915
    :cond_0
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-gt p1, v4, :cond_3

    .line 917
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v4

    add-int/lit8 v5, p1, -0x1

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/cleaner/TaskInfo;

    .line 929
    .local v0, "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    :goto_1
    if-eqz p2, :cond_1

    instance-of v4, p2, Landroid/widget/TextView;

    if-eqz v4, :cond_7

    .line 930
    :cond_1
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 931
    const v5, 0x7f0300a1

    .line 930
    invoke-static {v4, v5, v6}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 933
    .local v2, "view":Landroid/view/View;
    new-instance v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;

    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    invoke-direct {v3, v4, v6}, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;-><init>(Lcom/aio/downloader/cleaner/RubActivity;Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;)V

    .line 935
    .local v3, "views":Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;
    const v4, 0x7f07037a

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    .line 934
    iput-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->iv_process_icon:Landroid/widget/ImageView;

    .line 937
    const v4, 0x7f07037b

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 936
    iput-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->tv_process_name:Landroid/widget/TextView;

    .line 939
    const v4, 0x7f07037c

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 938
    iput-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->tv_process_memory:Landroid/widget/TextView;

    .line 941
    const v4, 0x7f070131

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/CheckBox;

    .line 940
    iput-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->cb_process_state:Landroid/widget/CheckBox;

    .line 942
    invoke-virtual {v2, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 943
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_6

    .line 946
    const-string v4, "www"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "getview_memory="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget v6, v6, Lcom/aio/downloader/cleaner/RubActivity;->MymemorySize:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 952
    :goto_3
    iget-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->iv_process_icon:Landroid/widget/ImageView;

    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 953
    iget-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->tv_process_name:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 954
    iget-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->tv_process_memory:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Junk File:"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 955
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->getMemory()I

    move-result v6

    int-to-long v6, v6

    invoke-static {v6, v7}, Lcom/aio/downloader/cleaner/TextFormater;->getSizeFromKB(J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 954
    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 956
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->bt_process_clear:Landroid/widget/Button;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity;->access$2(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/Button;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Junk File"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v6}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 958
    const-string v4, "com.allinone.free"

    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 959
    const-string v4, "system"

    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 960
    const-string v4, "android.process.media"

    .line 961
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 962
    :cond_2
    iget-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->cb_process_state:Landroid/widget/CheckBox;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Landroid/widget/CheckBox;->setVisibility(I)V

    .line 963
    iget-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->tv_process_memory:Landroid/widget/TextView;

    .line 964
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "Junk File:"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 965
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v6

    const-wide/high16 v8, 0x4024000000000000L    # 10.0

    mul-double/2addr v6, v8

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    add-double/2addr v6, v8

    double-to-int v6, v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 966
    const-string v6, "MB"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 964
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 970
    :goto_4
    iget-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->cb_process_state:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->isCheck()Z

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 971
    invoke-virtual {v0}, Lcom/aio/downloader/cleaner/TaskInfo;->isCheck()Z

    goto/16 :goto_0

    .line 918
    .end local v0    # "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    .end local v2    # "view":Landroid/view/View;
    .end local v3    # "views":Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    if-ne p1, v4, :cond_4

    .line 920
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "System process("

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->systemTaskInfos:Ljava/util/List;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/RubActivity;->access$20(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 921
    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 920
    invoke-direct {p0, v4}, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->newTextView(Ljava/lang/String;)Landroid/widget/TextView;

    move-result-object v2

    goto/16 :goto_0

    .line 922
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->taskInfos:Ljava/util/List;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity;->access$19(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, 0x2

    if-gt p1, v4, :cond_5

    .line 924
    iget-object v4, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->systemTaskInfos:Ljava/util/List;
    invoke-static {v4}, Lcom/aio/downloader/cleaner/RubActivity;->access$20(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v4

    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->userTaskInfos:Ljava/util/List;
    invoke-static {v5}, Lcom/aio/downloader/cleaner/RubActivity;->access$21(Lcom/aio/downloader/cleaner/RubActivity;)Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    sub-int v5, p1, v5

    .line 925
    add-int/lit8 v5, v5, -0x2

    .line 924
    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/cleaner/TaskInfo;

    .line 926
    .restart local v0    # "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    goto/16 :goto_1

    .line 927
    .end local v0    # "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    :cond_5
    new-instance v0, Lcom/aio/downloader/cleaner/TaskInfo;

    invoke-direct {v0}, Lcom/aio/downloader/cleaner/TaskInfo;-><init>()V

    .restart local v0    # "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    goto/16 :goto_1

    .line 943
    .restart local v2    # "view":Landroid/view/View;
    .restart local v3    # "views":Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;
    :cond_6
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/cleaner/TaskInfo;

    .line 944
    .local v1, "taskInfo1":Lcom/aio/downloader/cleaner/TaskInfo;
    iget-object v5, p0, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoAdapter;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    iget v6, v5, Lcom/aio/downloader/cleaner/RubActivity;->MymemorySize:I

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->getMemory()I

    move-result v7

    add-int/2addr v6, v7

    iput v6, v5, Lcom/aio/downloader/cleaner/RubActivity;->MymemorySize:I

    goto/16 :goto_2

    .line 949
    .end local v1    # "taskInfo1":Lcom/aio/downloader/cleaner/TaskInfo;
    .end local v2    # "view":Landroid/view/View;
    .end local v3    # "views":Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;
    :cond_7
    move-object v2, p2

    .line 950
    .restart local v2    # "view":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;

    .restart local v3    # "views":Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;
    goto/16 :goto_3

    .line 968
    :cond_8
    iget-object v4, v3, Lcom/aio/downloader/cleaner/RubActivity$TaskInfoViews;->cb_process_state:Landroid/widget/CheckBox;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/widget/CheckBox;->setVisibility(I)V

    goto/16 :goto_4
.end method
