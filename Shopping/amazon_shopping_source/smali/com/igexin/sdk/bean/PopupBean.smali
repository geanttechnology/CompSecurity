.class public Lcom/igexin/sdk/bean/PopupBean;
.super Lcom/igexin/sdk/bean/BaseBean;
.source "PopupBean.java"


# instance fields
.field private buttons:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/igexin/sdk/bean/ButtonBean;",
            ">;"
        }
    .end annotation
.end field

.field private content:Ljava/lang/String;

.field private imageUrl:Ljava/lang/String;

.field private img_src:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/igexin/sdk/bean/BaseBean;-><init>()V

    .line 17
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/igexin/sdk/bean/PopupBean;->img_src:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getButtons()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/igexin/sdk/bean/ButtonBean;",
            ">;"
        }
    .end annotation

    .prologue
    .line 38
    iget-object v0, p0, Lcom/igexin/sdk/bean/PopupBean;->buttons:Ljava/util/List;

    return-object v0
.end method

.method public getContent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/igexin/sdk/bean/PopupBean;->content:Ljava/lang/String;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/igexin/sdk/bean/PopupBean;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getImg_src()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/igexin/sdk/bean/PopupBean;->img_src:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/igexin/sdk/bean/PopupBean;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setButtons(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/igexin/sdk/bean/ButtonBean;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p1, "buttons":Ljava/util/List;, "Ljava/util/List<Lcom/igexin/sdk/bean/ButtonBean;>;"
    iput-object p1, p0, Lcom/igexin/sdk/bean/PopupBean;->buttons:Ljava/util/List;

    .line 43
    return-void
.end method

.method public setContent(Ljava/lang/String;)V
    .locals 0
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/igexin/sdk/bean/PopupBean;->content:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/igexin/sdk/bean/PopupBean;->imageUrl:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setImg_src(Ljava/lang/String;)V
    .locals 0
    .param p1, "img_src"    # Ljava/lang/String;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/igexin/sdk/bean/PopupBean;->img_src:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/igexin/sdk/bean/PopupBean;->title:Ljava/lang/String;

    .line 27
    return-void
.end method
