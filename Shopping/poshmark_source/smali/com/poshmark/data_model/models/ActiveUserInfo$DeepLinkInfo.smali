.class Lcom/poshmark/data_model/models/ActiveUserInfo$DeepLinkInfo;
.super Ljava/lang/Object;
.source "ActiveUserInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/ActiveUserInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DeepLinkInfo"
.end annotation


# instance fields
.field public deep_link:Ljava/lang/String;

.field source_app:Ljava/lang/String;

.field final synthetic this$0:Lcom/poshmark/data_model/models/ActiveUserInfo;


# direct methods
.method public constructor <init>(Lcom/poshmark/data_model/models/ActiveUserInfo;Ljava/lang/String;)V
    .locals 1
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$DeepLinkInfo;->this$0:Lcom/poshmark/data_model/models/ActiveUserInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$DeepLinkInfo;->deep_link:Ljava/lang/String;

    .line 35
    iput-object p2, p0, Lcom/poshmark/data_model/models/ActiveUserInfo$DeepLinkInfo;->deep_link:Ljava/lang/String;

    .line 36
    return-void
.end method
