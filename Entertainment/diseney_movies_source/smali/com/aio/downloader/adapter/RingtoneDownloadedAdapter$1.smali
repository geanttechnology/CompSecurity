.class Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;
.super Ljava/lang/Object;
.source "RingtoneDownloadedAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

.field private final synthetic val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 129
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    # invokes: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->initPopuWindow1(Landroid/view/View;)V
    invoke-static {v1, p1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$0(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;Landroid/view/View;)V

    .line 130
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 131
    sget-object v3, Lcom/aio/downloader/utils/Myutils;->packagename:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "ringtone/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 132
    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".mp3"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 130
    invoke-static {v1, v2}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$1(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;Ljava/lang/String;)V

    .line 133
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 134
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 135
    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 136
    sget-object v2, Lcom/aio/downloader/utils/Myutils;->packagename:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "ringtone"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 133
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->make_path_ready(Ljava/lang/String;)V

    .line 138
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->new_file_path:Ljava/lang/String;
    invoke-static {v2}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$2(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/publicTools;->copyFile(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 143
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    iget-object v1, v1, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->sp:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "movivename"

    iget-object v3, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->val$in_fo:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 144
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 146
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l1:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$3(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/LinearLayout;

    move-result-object v1

    new-instance v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$1;-><init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 156
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l2:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$5(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/LinearLayout;

    move-result-object v1

    new-instance v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$2;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$2;-><init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 165
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l3:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$6(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/LinearLayout;

    move-result-object v1

    new-instance v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$3;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$3;-><init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 174
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->l4:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$7(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/LinearLayout;

    move-result-object v1

    new-instance v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$4;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$4;-><init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 184
    iget-object v1, p0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;->this$0:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    # getter for: Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->popodismiss:Landroid/widget/RelativeLayout;
    invoke-static {v1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->access$8(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;)Landroid/widget/RelativeLayout;

    move-result-object v1

    new-instance v2, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$5;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1$5;-><init>(Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter$1;)V

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 193
    return-void

    .line 139
    :catch_0
    move-exception v0

    .line 140
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method
