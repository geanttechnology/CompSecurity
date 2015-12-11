.class Lco/vine/android/UploadsListFragment$UploadProgressHandler;
.super Landroid/os/Handler;
.source "UploadsListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/UploadsListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "UploadProgressHandler"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/UploadsListFragment;


# direct methods
.method private constructor <init>(Lco/vine/android/UploadsListFragment;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/UploadsListFragment;Lco/vine/android/UploadsListFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/UploadsListFragment;
    .param p2, "x1"    # Lco/vine/android/UploadsListFragment$1;

    .prologue
    .line 105
    invoke-direct {p0, p1}, Lco/vine/android/UploadsListFragment$UploadProgressHandler;-><init>(Lco/vine/android/UploadsListFragment;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 12
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 108
    iget v6, p1, Landroid/os/Message;->what:I

    .line 109
    .local v6, "what":I
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/os/Bundle;

    .line 110
    .local v0, "data":Landroid/os/Bundle;
    const-string v7, "UploadsListFragment"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Message received, what="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 112
    packed-switch v6, :pswitch_data_0

    .line 138
    :cond_0
    :goto_0
    return-void

    .line 114
    :pswitch_0
    iget-object v7, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    # getter for: Lco/vine/android/UploadsListFragment;->mStatusMessage:Landroid/widget/TextView;
    invoke-static {v7}, Lco/vine/android/UploadsListFragment;->access$500(Lco/vine/android/UploadsListFragment;)Landroid/widget/TextView;

    move-result-object v7

    if-eqz v7, :cond_0

    iget-object v7, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    # getter for: Lco/vine/android/UploadsListFragment;->mProgressView:Lco/vine/android/recorder/ProgressView;
    invoke-static {v7}, Lco/vine/android/UploadsListFragment;->access$600(Lco/vine/android/UploadsListFragment;)Lco/vine/android/recorder/ProgressView;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 115
    const-string v7, "upload_progress"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v1

    .line 116
    .local v1, "p":D
    const-string v7, "UploadsListFragment"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Upload progress changed to p="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1, v2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    iget-object v7, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    # getter for: Lco/vine/android/UploadsListFragment;->mProgressViewWidth:I
    invoke-static {v7}, Lco/vine/android/UploadsListFragment;->access$700(Lco/vine/android/UploadsListFragment;)I

    move-result v7

    if-nez v7, :cond_1

    .line 118
    iget-object v7, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    iget-object v8, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    # getter for: Lco/vine/android/UploadsListFragment;->mProgressView:Lco/vine/android/recorder/ProgressView;
    invoke-static {v8}, Lco/vine/android/UploadsListFragment;->access$600(Lco/vine/android/UploadsListFragment;)Lco/vine/android/recorder/ProgressView;

    move-result-object v8

    invoke-virtual {v8}, Lco/vine/android/recorder/ProgressView;->getMeasuredWidth()I

    move-result v8

    # setter for: Lco/vine/android/UploadsListFragment;->mProgressViewWidth:I
    invoke-static {v7, v8}, Lco/vine/android/UploadsListFragment;->access$702(Lco/vine/android/UploadsListFragment;I)I

    .line 120
    :cond_1
    const-wide v3, 0x3fef5c28f5c28f5cL    # 0.98

    .line 121
    .local v3, "ratio":D
    iget-object v7, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    # getter for: Lco/vine/android/UploadsListFragment;->mProgressView:Lco/vine/android/recorder/ProgressView;
    invoke-static {v7}, Lco/vine/android/UploadsListFragment;->access$600(Lco/vine/android/UploadsListFragment;)Lco/vine/android/recorder/ProgressView;

    move-result-object v7

    const-wide v8, 0x3fef5c28f5c28f5cL    # 0.98

    mul-double/2addr v8, v1

    const-wide/high16 v10, 0x4059000000000000L    # 100.0

    div-double/2addr v8, v10

    double-to-float v8, v8

    invoke-virtual {v7, v8}, Lco/vine/android/recorder/ProgressView;->setProgressRatio(F)V

    .line 122
    iget-object v7, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    # getter for: Lco/vine/android/UploadsListFragment;->mStatusMessage:Landroid/widget/TextView;
    invoke-static {v7}, Lco/vine/android/UploadsListFragment;->access$500(Lco/vine/android/UploadsListFragment;)Landroid/widget/TextView;

    move-result-object v7

    iget-object v8, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    const v9, 0x7f0e0260

    invoke-virtual {v8, v9}, Lco/vine/android/UploadsListFragment;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 127
    .end local v1    # "p":D
    .end local v3    # "ratio":D
    :pswitch_1
    const-string v7, "success"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v5

    .line 128
    .local v5, "success":Z
    const-string v7, "UploadsListFragment"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Post completed, success="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 129
    const/4 v7, 0x0

    const/4 v8, 0x2

    invoke-static {v7, v8}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v7

    invoke-virtual {p0, v7}, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->sendMessage(Landroid/os/Message;)Z

    .line 130
    if-eqz v5, :cond_2

    .line 131
    iget-object v7, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    # getter for: Lco/vine/android/UploadsListFragment;->mStatusMessage:Landroid/widget/TextView;
    invoke-static {v7}, Lco/vine/android/UploadsListFragment;->access$500(Lco/vine/android/UploadsListFragment;)Landroid/widget/TextView;

    move-result-object v7

    iget-object v8, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    const v9, 0x7f0e025f

    invoke-virtual {v8, v9}, Lco/vine/android/UploadsListFragment;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 133
    :cond_2
    iget-object v7, p0, Lco/vine/android/UploadsListFragment$UploadProgressHandler;->this$0:Lco/vine/android/UploadsListFragment;

    # invokes: Lco/vine/android/UploadsListFragment;->resetFailedUpload()V
    invoke-static {v7}, Lco/vine/android/UploadsListFragment;->access$800(Lco/vine/android/UploadsListFragment;)V

    goto/16 :goto_0

    .line 112
    :pswitch_data_0
    .packed-switch 0x6
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
