.class public Lco/vine/android/PostOptionsDialogActivity;
.super Lco/vine/android/SupportListActivity;
.source "PostOptionsDialogActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/PostOptionsDialogActivity$OptionArrayAdapter;,
        Lco/vine/android/PostOptionsDialogActivity$Result;,
        Lco/vine/android/PostOptionsDialogActivity$Option;
    }
.end annotation


# static fields
.field public static final ACTION_DELETE:Ljava/lang/String; = "action_delete"

.field public static final ACTION_FACEBOOK:Ljava/lang/String; = "action_facebook"

.field public static final ACTION_ORIGINAL_POST:Ljava/lang/String; = "action_original_post"

.field public static final ACTION_REPORT:Ljava/lang/String; = "action_report"

.field public static final ACTION_REVINE:Ljava/lang/String; = "action_revine"

.field public static final ACTION_SHARE_OTHER:Ljava/lang/String; = "action_other"

.field public static final ACTION_TWITTER:Ljava/lang/String; = "action_twitter"

.field public static final ACTION_VM:Ljava/lang/String; = "action_vm"

.field private static final DIALOG_DELETE:I = 0x2

.field private static final DIALOG_REPORT:I = 0x1

.field public static final EXTRA_DELETE:Ljava/lang/String; = "delete"

.field public static final EXTRA_DESCRIPTION:Ljava/lang/String; = "description"

.field public static final EXTRA_FLURRY_EVENT_SOURCE:Ljava/lang/String; = "flurry_event_source"

.field public static final EXTRA_FOLLOWING:Ljava/lang/String; = "following"

.field public static final EXTRA_NAME:Ljava/lang/String; = "name"

.field public static final EXTRA_ORIGINAL_POST:Ljava/lang/String; = "original_post"

.field public static final EXTRA_POST_FACEBOOK:Ljava/lang/String; = "post_facebook"

.field public static final EXTRA_POST_ID:Ljava/lang/String; = "post_id"

.field public static final EXTRA_POST_TWITTER:Ljava/lang/String; = "post_twitter"

.field public static final EXTRA_POST_USER_ID:Ljava/lang/String; = "post_user_id"

.field public static final EXTRA_REPORT:Ljava/lang/String; = "report"

.field public static final EXTRA_REVINE:Ljava/lang/String; = "revine"

.field private static final EXTRA_REVINE_ID:Ljava/lang/String; = "revine_id"

.field public static final EXTRA_SHARE_OTHER:Ljava/lang/String; = "share_other"

.field public static final EXTRA_SHARE_URL:Ljava/lang/String; = "share_url"

.field public static final EXTRA_SHARE_VM:Ljava/lang/String; = "share_vm"

.field public static final EXTRA_THUMBNAIL_URL:Ljava/lang/String; = "thumbnail_url"

.field public static final EXTRA_VIDEO_URL:Ljava/lang/String; = "video_url"

.field public static final EXTRA_WAS_REVINED:Ljava/lang/String; = "was_revined"

.field private static final ID_CANCEL:I = 0x7

.field private static final ID_DELETE:I = 0x6

.field private static final ID_FACEBOOK:I = 0x2

.field private static final ID_ORIGINAL_POST:I = 0x8

.field private static final ID_REPORT:I = 0x5

.field private static final ID_REVINE:I = 0x9

.field private static final ID_SHARE_MORE:I = 0xa

.field private static final ID_SHARE_OTHER:I = 0x4

.field private static final ID_TWITTER:I = 0x1

.field private static final ID_VM:I = 0x3


# instance fields
.field private mArrayAdapter:Landroid/widget/ArrayAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/widget/ArrayAdapter",
            "<",
            "Lco/vine/android/PostOptionsDialogActivity$Option;",
            ">;"
        }
    .end annotation
.end field

.field private mDelete:Z

.field private mItems2:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/PostOptionsDialogActivity$Option;",
            ">;"
        }
    .end annotation
.end field

.field private mName:Ljava/lang/String;

.field private mOriginalPost:Z

.field private mPostFacebook:Z

.field private mPostId:J

.field private mPostTwitter:Z

.field private mReport:Z

.field private mRevine:Z

.field private mShareOther:Z

.field private mVm:Z

.field private mWasRevined:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lco/vine/android/SupportListActivity;-><init>()V

    .line 420
    return-void
.end method

.method public static getMoreIntent(Lco/vine/android/api/VinePost;Landroid/content/Context;ZZ)Landroid/content/Intent;
    .locals 5
    .param p0, "post"    # Lco/vine/android/api/VinePost;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "isMyPost"    # Z
    .param p3, "showOriginalPost"    # Z

    .prologue
    .line 299
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lco/vine/android/PostOptionsDialogActivity;

    invoke-direct {v1, p1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v2, "post_id"

    iget-wide v3, p0, Lco/vine/android/api/VinePost;->postId:J

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    move-result-object v1

    const-string v2, "delete"

    invoke-virtual {v1, v2, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v1

    const-string v2, "report"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    move-result-object v0

    .line 303
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "original_post"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 304
    return-object v0
.end method

.method public static getShareIntent(Lco/vine/android/api/VinePost;Landroid/content/Context;ZJLjava/lang/String;)Landroid/content/Intent;
    .locals 7
    .param p0, "post"    # Lco/vine/android/api/VinePost;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "isMyPost"    # Z
    .param p3, "revineId"    # J
    .param p5, "flurryEventSource"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 308
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/PostOptionsDialogActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 309
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "post_id"

    iget-wide v4, p0, Lco/vine/android/api/VinePost;->postId:J

    invoke-virtual {v0, v1, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 310
    const-string v1, "report"

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 311
    const-string v4, "revine"

    if-nez p2, :cond_7

    move v1, v2

    :goto_0
    invoke-virtual {v0, v4, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 312
    const-string v1, "revine_id"

    invoke-virtual {v0, v1, p3, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 313
    const-string v1, "post_user_id"

    iget-wide v4, p0, Lco/vine/android/api/VinePost;->userId:J

    invoke-virtual {v0, v1, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 314
    const-string v4, "following"

    iget-object v1, p0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    if-eqz v1, :cond_8

    iget-object v1, p0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    invoke-virtual {v1}, Lco/vine/android/api/VineUser;->isFollowing()Z

    move-result v1

    if-eqz v1, :cond_8

    move v1, v2

    :goto_1
    invoke-virtual {v0, v4, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 315
    const-string v4, "was_revined"

    const-wide/16 v5, 0x0

    cmp-long v1, p3, v5

    if-lez v1, :cond_9

    move v1, v2

    :goto_2
    invoke-virtual {v0, v4, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 316
    const-string v1, "flurry_event_source"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 318
    invoke-virtual {p0}, Lco/vine/android/api/VinePost;->isShareable()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lco/vine/android/api/VinePost;->isPrivate()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    if-eqz p2, :cond_6

    .line 319
    :cond_1
    const-string v4, "post_twitter"

    invoke-virtual {p0}, Lco/vine/android/api/VinePost;->isShareable()Z

    move-result v1

    if-nez v1, :cond_2

    if-eqz p2, :cond_a

    :cond_2
    move v1, v2

    :goto_3
    invoke-virtual {v0, v4, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 321
    const-string v4, "post_facebook"

    invoke-virtual {p0}, Lco/vine/android/api/VinePost;->isShareable()Z

    move-result v1

    if-nez v1, :cond_3

    if-eqz p2, :cond_b

    :cond_3
    move v1, v2

    :goto_4
    invoke-virtual {v0, v4, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 323
    const-string v4, "share_other"

    invoke-virtual {p0}, Lco/vine/android/api/VinePost;->isShareable()Z

    move-result v1

    if-nez v1, :cond_4

    if-eqz p2, :cond_c

    :cond_4
    move v1, v2

    :goto_5
    invoke-virtual {v0, v4, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 325
    const-string v1, "share_vm"

    invoke-virtual {p0}, Lco/vine/android/api/VinePost;->isShareable()Z

    move-result v4

    if-nez v4, :cond_5

    if-eqz p2, :cond_d

    :cond_5
    :goto_6
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 327
    const-string v1, "description"

    iget-object v2, p0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 328
    const-string v1, "share_url"

    iget-object v2, p0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 329
    const-string v1, "thumbnail_url"

    iget-object v2, p0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 330
    const-string v1, "video_url"

    iget-object v2, p0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 331
    const-string v1, "name"

    iget-object v2, p0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 332
    const-string v1, "original_post"

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 335
    :cond_6
    return-object v0

    :cond_7
    move v1, v3

    .line 311
    goto/16 :goto_0

    :cond_8
    move v1, v3

    .line 314
    goto/16 :goto_1

    :cond_9
    move v1, v3

    .line 315
    goto :goto_2

    :cond_a
    move v1, v3

    .line 319
    goto :goto_3

    :cond_b
    move v1, v3

    .line 321
    goto :goto_4

    :cond_c
    move v1, v3

    .line 323
    goto :goto_5

    :cond_d
    move v2, v3

    .line 325
    goto :goto_6
.end method

.method private invalidateOptions(Ljava/util/ArrayList;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/PostOptionsDialogActivity$Option;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 159
    .local p1, "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/PostOptionsDialogActivity$Option;>;"
    iget-object v2, p0, Lco/vine/android/PostOptionsDialogActivity;->mArrayAdapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v2}, Landroid/widget/ArrayAdapter;->clear()V

    .line 161
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/PostOptionsDialogActivity$Option;

    .line 162
    .local v1, "item":Lco/vine/android/PostOptionsDialogActivity$Option;
    iget-object v2, p0, Lco/vine/android/PostOptionsDialogActivity;->mArrayAdapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v2, v1}, Landroid/widget/ArrayAdapter;->add(Ljava/lang/Object;)V

    goto :goto_0

    .line 164
    .end local v1    # "item":Lco/vine/android/PostOptionsDialogActivity$Option;
    :cond_0
    iget-object v2, p0, Lco/vine/android/PostOptionsDialogActivity;->mArrayAdapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {p0, v2}, Lco/vine/android/PostOptionsDialogActivity;->setListAdapter(Landroid/widget/ListAdapter;)V

    .line 165
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->getListView()Landroid/widget/ListView;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 166
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->getListView()Landroid/widget/ListView;

    move-result-object v2

    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->getListAdapter()Landroid/widget/ListAdapter;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 167
    return-void
.end method

.method public static onActivityResult(Lco/vine/android/client/AppController;Landroid/app/Activity;ILandroid/content/Intent;)Lco/vine/android/PostOptionsDialogActivity$Result;
    .locals 29
    .param p0, "appController"    # Lco/vine/android/client/AppController;
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 349
    const/16 v22, 0x0

    .line 350
    .local v22, "request":Ljava/lang/String;
    const/16 v20, 0x0

    .line 351
    .local v20, "intent":Landroid/content/Intent;
    const/4 v3, -0x1

    move/from16 v0, p2

    if-ne v0, v3, :cond_0

    .line 352
    if-eqz p3, :cond_0

    .line 353
    invoke-virtual/range {p3 .. p3}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v19

    .line 354
    .local v19, "action":Ljava/lang/String;
    const-string v3, "action_report"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 355
    const-string v3, "post_id"

    const-wide/16 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v13, v14}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v6

    .line 357
    .local v6, "postId":J
    const-wide/16 v13, 0x0

    cmp-long v3, v6, v13

    if-lez v3, :cond_0

    .line 358
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v6, v7}, Lco/vine/android/client/AppController;->reportPost(Lco/vine/android/client/Session;J)Ljava/lang/String;

    move-result-object v22

    .line 417
    .end local v6    # "postId":J
    .end local v19    # "action":Ljava/lang/String;
    :cond_0
    :goto_0
    new-instance v3, Lco/vine/android/PostOptionsDialogActivity$Result;

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-direct {v3, v0, v1}, Lco/vine/android/PostOptionsDialogActivity$Result;-><init>(Ljava/lang/String;Landroid/content/Intent;)V

    return-object v3

    .line 361
    .restart local v19    # "action":Ljava/lang/String;
    :cond_1
    const-string v3, "action_delete"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 362
    const-string v3, "post_id"

    const-wide/16 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v13, v14}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v6

    .line 364
    .restart local v6    # "postId":J
    const-wide/16 v13, 0x0

    cmp-long v3, v6, v13

    if-lez v3, :cond_0

    .line 365
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v6, v7}, Lco/vine/android/client/AppController;->deletePost(Lco/vine/android/client/Session;J)Ljava/lang/String;

    move-result-object v22

    goto :goto_0

    .line 368
    .end local v6    # "postId":J
    :cond_2
    const-string v3, "action_twitter"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 369
    const-string v3, "twitter"

    invoke-virtual/range {p3 .. p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-static {v0, v3, v5}, Lco/vine/android/ReshareActivity;->getReshareIntent(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v20

    goto :goto_0

    .line 370
    :cond_3
    const-string v3, "action_facebook"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 371
    const-string v3, "facebook"

    invoke-virtual/range {p3 .. p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-static {v0, v3, v5}, Lco/vine/android/ReshareActivity;->getReshareIntent(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v20

    goto :goto_0

    .line 372
    :cond_4
    const-string v3, "action_vm"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 373
    const-string v3, "post_id"

    const-wide/16 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v13, v14}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v6

    .line 375
    .restart local v6    # "postId":J
    const-string v3, "video_url"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    .line 376
    .local v27, "videoUrl":Ljava/lang/String;
    const-string v3, "thumbnail_url"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v25

    .line 377
    .local v25, "thumbUrl":Ljava/lang/String;
    const-wide/16 v13, 0x0

    cmp-long v3, v6, v13

    if-lez v3, :cond_0

    .line 378
    move-object/from16 v0, p1

    move-object/from16 v1, v27

    move-object/from16 v2, v25

    invoke-static {v0, v6, v7, v1, v2}, Lco/vine/android/RecipientPickerActivity;->getIntent(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v20

    goto/16 :goto_0

    .line 380
    .end local v6    # "postId":J
    .end local v25    # "thumbUrl":Ljava/lang/String;
    .end local v27    # "videoUrl":Ljava/lang/String;
    :cond_5
    const-string v3, "action_other"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 381
    const-string v3, "other"

    const-string v5, "post_id"

    const-wide/16 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v5, v13, v14}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v13

    invoke-static {v3, v13, v14}, Lco/vine/android/util/FlurryUtils;->trackSharePost(Ljava/lang/String;J)V

    .line 382
    invoke-virtual/range {p1 .. p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v23

    .line 383
    .local v23, "res":Landroid/content/res/Resources;
    const-string v3, "name"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 385
    .local v21, "name":Ljava/lang/String;
    const-string v3, "share_url"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v26

    .line 386
    .local v26, "url":Ljava/lang/String;
    new-instance v24, Landroid/content/Intent;

    const-string v3, "android.intent.action.SEND"

    move-object/from16 v0, v24

    invoke-direct {v0, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 387
    .local v24, "share":Landroid/content/Intent;
    const-string v3, "text/plain"

    move-object/from16 v0, v24

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 388
    const/high16 v3, 0x80000

    move-object/from16 v0, v24

    invoke-virtual {v0, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 389
    const-string v3, "android.intent.extra.SUBJECT"

    const v5, 0x7f0e0209

    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    aput-object v21, v13, v14

    move-object/from16 v0, v23

    invoke-virtual {v0, v5, v13}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v24

    invoke-virtual {v0, v3, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 390
    const-string v3, "android.intent.extra.TEXT"

    const v5, 0x7f0e020a

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    aput-object v21, v13, v14

    const/4 v14, 0x1

    aput-object v26, v13, v14

    move-object/from16 v0, v23

    invoke-virtual {v0, v5, v13}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v24

    invoke-virtual {v0, v3, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 391
    move-object/from16 v20, v24

    .line 392
    goto/16 :goto_0

    .end local v21    # "name":Ljava/lang/String;
    .end local v23    # "res":Landroid/content/res/Resources;
    .end local v24    # "share":Landroid/content/Intent;
    .end local v26    # "url":Ljava/lang/String;
    :cond_6
    const-string v3, "action_original_post"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 393
    const-string v3, "post_id"

    const-wide/16 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v13, v14}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v6

    .line 395
    .restart local v6    # "postId":J
    const-wide/16 v13, 0x0

    cmp-long v3, v6, v13

    if-lez v3, :cond_0

    .line 396
    move-object/from16 v0, p1

    invoke-static {v0, v6, v7}, Lco/vine/android/SingleActivity;->getIntent(Landroid/content/Context;J)Landroid/content/Intent;

    move-result-object v20

    goto/16 :goto_0

    .line 398
    .end local v6    # "postId":J
    :cond_7
    const-string v3, "action_revine"

    move-object/from16 v0, v19

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 399
    const-string v3, "post_id"

    const-wide/16 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v13, v14}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v6

    .line 400
    .restart local v6    # "postId":J
    const-string v3, "revine_id"

    const-wide/16 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v13, v14}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v8

    .line 401
    .local v8, "revineId":J
    const-string v3, "post_user_id"

    const-wide/16 v13, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v13, v14}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v11

    .line 402
    .local v11, "postUserId":J
    const-string v3, "following"

    const/4 v5, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v5}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v10

    .line 403
    .local v10, "following":Z
    const-string v3, "was_revined"

    const/4 v5, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v5}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v28

    .line 404
    .local v28, "wasRevined":Z
    const-string v3, "flurry_event_source"

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 405
    .local v4, "flurryEventSource":Ljava/lang/String;
    if-eqz v28, :cond_8

    .line 407
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v5

    const/4 v13, 0x1

    move-object/from16 v3, p0

    invoke-virtual/range {v3 .. v13}, Lco/vine/android/client/AppController;->unRevine(Ljava/lang/String;Lco/vine/android/client/Session;JJZJZ)Ljava/lang/String;

    move-result-object v22

    goto/16 :goto_0

    .line 411
    :cond_8
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v15

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/client/Session;->getName()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v13, p0

    move-object v14, v4

    move-wide/from16 v16, v6

    invoke-virtual/range {v13 .. v18}, Lco/vine/android/client/AppController;->revine(Ljava/lang/String;Lco/vine/android/client/Session;JLjava/lang/String;)Ljava/lang/String;

    move-result-object v22

    goto/16 :goto_0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 172
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 11
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const v10, 0x7f0e0057

    const/4 v9, 0x7

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 92
    invoke-super {p0, p1}, Lco/vine/android/SupportListActivity;->onCreate(Landroid/os/Bundle;)V

    .line 93
    const v5, 0x7f030068

    invoke-virtual {p0, v5}, Lco/vine/android/PostOptionsDialogActivity;->setContentView(I)V

    .line 94
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 95
    .local v0, "b":Landroid/os/Bundle;
    const-string v5, "post_twitter"

    invoke-virtual {v0, v5, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mPostTwitter:Z

    .line 96
    const-string v5, "post_facebook"

    invoke-virtual {v0, v5, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mPostFacebook:Z

    .line 97
    const-string v5, "share_other"

    invoke-virtual {v0, v5, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mShareOther:Z

    .line 98
    const-string v5, "share_vm"

    invoke-virtual {v0, v5, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mVm:Z

    .line 99
    const-string v5, "report"

    invoke-virtual {v0, v5, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mReport:Z

    .line 100
    const-string v5, "delete"

    invoke-virtual {v0, v5, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mDelete:Z

    .line 101
    const-string v5, "revine"

    invoke-virtual {v0, v5, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mRevine:Z

    .line 102
    const-string v5, "was_revined"

    invoke-virtual {v0, v5, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mWasRevined:Z

    .line 103
    const-string v5, "post_id"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v5

    iput-wide v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mPostId:J

    .line 104
    const-string v5, "name"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mName:Ljava/lang/String;

    .line 105
    const-string v5, "original_post"

    invoke-virtual {v0, v5, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    iput-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mOriginalPost:Z

    .line 107
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 108
    .local v3, "res":Landroid/content/res/Resources;
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$OptionArrayAdapter;

    const v6, 0x7f03006b

    invoke-direct {v5, p0, p0, v6}, Lco/vine/android/PostOptionsDialogActivity$OptionArrayAdapter;-><init>(Lco/vine/android/PostOptionsDialogActivity;Landroid/content/Context;I)V

    iput-object v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mArrayAdapter:Landroid/widget/ArrayAdapter;

    .line 110
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 112
    .local v1, "items":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/PostOptionsDialogActivity$Option;>;"
    iget-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mVm:Z

    if-eqz v5, :cond_0

    .line 113
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    const/4 v6, 0x3

    const v7, 0x7f0e0214

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 116
    :cond_0
    iget-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mRevine:Z

    if-eqz v5, :cond_1

    .line 117
    iget-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mWasRevined:Z

    if-eqz v5, :cond_9

    const v4, 0x7f0e0255

    .line 118
    .local v4, "revineStringId":I
    :goto_0
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    const/16 v6, 0x9

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 121
    .end local v4    # "revineStringId":I
    :cond_1
    iget-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mOriginalPost:Z

    if-eqz v5, :cond_2

    .line 122
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    const/16 v6, 0x8

    const v7, 0x7f0e0168

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 125
    :cond_2
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 127
    .local v2, "items2":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/PostOptionsDialogActivity$Option;>;"
    iget-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mPostTwitter:Z

    if-eqz v5, :cond_3

    .line 128
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    const v6, 0x7f0e0212

    invoke-virtual {v3, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v8, v6}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 130
    :cond_3
    iget-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mPostFacebook:Z

    if-eqz v5, :cond_4

    .line 131
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    const/4 v6, 0x2

    const v7, 0x7f0e0204

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 134
    :cond_4
    iget-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mShareOther:Z

    if-eqz v5, :cond_5

    .line 135
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    const/4 v6, 0x4

    const v7, 0x7f0e0208

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 138
    :cond_5
    iget-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mReport:Z

    if-eqz v5, :cond_6

    .line 139
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    const/4 v6, 0x5

    const v7, 0x7f0e01a6

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 142
    :cond_6
    iget-boolean v5, p0, Lco/vine/android/PostOptionsDialogActivity;->mDelete:Z

    if-eqz v5, :cond_7

    .line 143
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    const/4 v6, 0x6

    const v7, 0x7f0e00b5

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 146
    :cond_7
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_8

    .line 147
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    const/16 v6, 0xa

    const v7, 0x7f0e0147

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 148
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    invoke-virtual {v3, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v9, v6}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 151
    :cond_8
    iput-object v2, p0, Lco/vine/android/PostOptionsDialogActivity;->mItems2:Ljava/util/ArrayList;

    .line 153
    new-instance v5, Lco/vine/android/PostOptionsDialogActivity$Option;

    invoke-virtual {v3, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v9, v6}, Lco/vine/android/PostOptionsDialogActivity$Option;-><init>(ILjava/lang/String;)V

    invoke-virtual {v1, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 155
    invoke-direct {p0, v1}, Lco/vine/android/PostOptionsDialogActivity;->invalidateOptions(Ljava/util/ArrayList;)V

    .line 156
    return-void

    .line 117
    .end local v2    # "items2":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/PostOptionsDialogActivity$Option;>;"
    :cond_9
    const v4, 0x7f0e01b2

    goto/16 :goto_0
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    const/4 v4, -0x1

    .line 253
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 254
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "post_id"

    iget-wide v2, p0, Lco/vine/android/PostOptionsDialogActivity;->mPostId:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 255
    packed-switch p2, :pswitch_data_0

    .line 285
    :goto_0
    return-void

    .line 257
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 259
    :pswitch_1
    const-string v1, "action_report"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 260
    invoke-virtual {p0, v4, v0}, Lco/vine/android/PostOptionsDialogActivity;->setResult(ILandroid/content/Intent;)V

    .line 261
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->finish()V

    goto :goto_0

    .line 271
    :pswitch_2
    packed-switch p3, :pswitch_data_2

    goto :goto_0

    .line 273
    :pswitch_3
    const-string v1, "action_delete"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 274
    invoke-virtual {p0, v4, v0}, Lco/vine/android/PostOptionsDialogActivity;->setResult(ILandroid/content/Intent;)V

    .line 275
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->finish()V

    goto :goto_0

    .line 255
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
    .end packed-switch

    .line 257
    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_1
    .end packed-switch

    .line 271
    :pswitch_data_2
    .packed-switch -0x1
        :pswitch_3
    .end packed-switch
.end method

.method protected onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 7
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    const v4, 0x7f0e0057

    const/4 v6, -0x1

    .line 176
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 177
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 178
    .local v1, "optionId":I
    packed-switch v1, :pswitch_data_0

    .line 249
    :goto_0
    return-void

    .line 180
    :pswitch_0
    iget-object v3, p0, Lco/vine/android/PostOptionsDialogActivity;->mItems2:Ljava/util/ArrayList;

    invoke-direct {p0, v3}, Lco/vine/android/PostOptionsDialogActivity;->invalidateOptions(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 184
    :pswitch_1
    const-string v3, "action_original_post"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 185
    invoke-virtual {p0, v6, v0}, Lco/vine/android/PostOptionsDialogActivity;->setResult(ILandroid/content/Intent;)V

    .line 186
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->finish()V

    goto :goto_0

    .line 190
    :pswitch_2
    const-string v3, "action_twitter"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 191
    invoke-virtual {p0, v6, v0}, Lco/vine/android/PostOptionsDialogActivity;->setResult(ILandroid/content/Intent;)V

    .line 192
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->finish()V

    goto :goto_0

    .line 196
    :pswitch_3
    const-string v3, "action_facebook"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 197
    invoke-virtual {p0, v6, v0}, Lco/vine/android/PostOptionsDialogActivity;->setResult(ILandroid/content/Intent;)V

    .line 198
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->finish()V

    goto :goto_0

    .line 202
    :pswitch_4
    const-string v3, "action_vm"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 203
    invoke-virtual {p0, v6, v0}, Lco/vine/android/PostOptionsDialogActivity;->setResult(ILandroid/content/Intent;)V

    .line 204
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->finish()V

    goto :goto_0

    .line 208
    :pswitch_5
    const-string v3, "post_id"

    iget-wide v4, p0, Lco/vine/android/PostOptionsDialogActivity;->mPostId:J

    invoke-virtual {v0, v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 209
    const-string v3, "action_other"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 210
    invoke-virtual {p0, v6, v0}, Lco/vine/android/PostOptionsDialogActivity;->setResult(ILandroid/content/Intent;)V

    .line 211
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->finish()V

    goto :goto_0

    .line 215
    :pswitch_6
    const/4 v3, 0x1

    invoke-static {v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    .line 217
    .local v2, "promptDialogFragment":Lco/vine/android/widgets/PromptDialogSupportFragment;
    invoke-virtual {v2, p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V

    .line 218
    const v3, 0x7f0e01a7

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 219
    const v3, 0x7f0e01a6

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 220
    invoke-virtual {v2, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 221
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    goto :goto_0

    .line 225
    .end local v2    # "promptDialogFragment":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :pswitch_7
    const/4 v3, 0x2

    invoke-static {v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    .line 227
    .restart local v2    # "promptDialogFragment":Lco/vine/android/widgets/PromptDialogSupportFragment;
    invoke-virtual {v2, p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V

    .line 228
    const v3, 0x7f0e00ae

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 229
    const v3, 0x7f0e00b5

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 230
    invoke-virtual {v2, v4}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 231
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    goto/16 :goto_0

    .line 235
    .end local v2    # "promptDialogFragment":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :pswitch_8
    const/4 v3, 0x0

    invoke-virtual {p0, v3, v0}, Lco/vine/android/PostOptionsDialogActivity;->setResult(ILandroid/content/Intent;)V

    .line 236
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->finish()V

    goto/16 :goto_0

    .line 240
    :pswitch_9
    const-string v3, "action_revine"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 241
    invoke-virtual {p0, v6, v0}, Lco/vine/android/PostOptionsDialogActivity;->setResult(ILandroid/content/Intent;)V

    .line 242
    invoke-virtual {p0}, Lco/vine/android/PostOptionsDialogActivity;->finish()V

    goto/16 :goto_0

    .line 178
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_1
        :pswitch_9
        :pswitch_0
    .end packed-switch
.end method
