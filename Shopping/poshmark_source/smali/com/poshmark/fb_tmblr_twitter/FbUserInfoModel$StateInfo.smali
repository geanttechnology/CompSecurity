.class Lcom/poshmark/fb_tmblr_twitter/FbUserInfoModel$StateInfo;
.super Ljava/lang/Object;
.source "FbUserInfoModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/fb_tmblr_twitter/FbUserInfoModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "StateInfo"
.end annotation


# instance fields
.field email:Ljava/lang/String;

.field first_name:Ljava/lang/String;

.field last_name:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/fb_tmblr_twitter/FbUserInfoModel;


# direct methods
.method constructor <init>(Lcom/poshmark/fb_tmblr_twitter/FbUserInfoModel;)V
    .locals 0

    .prologue
    .line 7
    iput-object p1, p0, Lcom/poshmark/fb_tmblr_twitter/FbUserInfoModel$StateInfo;->this$0:Lcom/poshmark/fb_tmblr_twitter/FbUserInfoModel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
