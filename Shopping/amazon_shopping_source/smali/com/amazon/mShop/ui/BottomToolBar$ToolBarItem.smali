.class public Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
.super Ljava/lang/Object;
.source "BottomToolBar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/ui/BottomToolBar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToolBarItem"
.end annotation


# instance fields
.field private mIconId:I

.field private mIsEnabled:Z

.field private mItemId:I

.field private mItemName:Ljava/lang/String;

.field private mItemNameId:I


# direct methods
.method public constructor <init>(IIIZ)V
    .locals 0
    .param p1, "itemId"    # I
    .param p2, "itemNameId"    # I
    .param p3, "iconId"    # I
    .param p4, "isEnabled"    # Z

    .prologue
    .line 298
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 299
    iput p2, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mItemNameId:I

    .line 300
    iput p1, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mItemId:I

    .line 301
    iput-boolean p4, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mIsEnabled:Z

    .line 302
    iput p3, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mIconId:I

    .line 303
    return-void
.end method

.method public constructor <init>(IIZ)V
    .locals 1
    .param p1, "itemId"    # I
    .param p2, "itemNameId"    # I
    .param p3, "isEnabled"    # Z

    .prologue
    .line 313
    const/4 v0, -0x1

    invoke-direct {p0, p1, p2, v0, p3}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;-><init>(IIIZ)V

    .line 314
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Z)V
    .locals 1
    .param p1, "itemId"    # I
    .param p2, "itemName"    # Ljava/lang/String;
    .param p3, "isEnabled"    # Z

    .prologue
    .line 305
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 306
    iput-object p2, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mItemName:Ljava/lang/String;

    .line 307
    iput p1, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mItemId:I

    .line 308
    iput-boolean p3, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mIsEnabled:Z

    .line 309
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mIconId:I

    .line 310
    return-void
.end method


# virtual methods
.method public getIconId()I
    .locals 1

    .prologue
    .line 343
    iget v0, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mIconId:I

    return v0
.end method

.method public getItemId()I
    .locals 1

    .prologue
    .line 335
    iget v0, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mItemId:I

    return v0
.end method

.method public getItemName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mItemName:Ljava/lang/String;

    return-object v0
.end method

.method public getItemNameId()I
    .locals 1

    .prologue
    .line 322
    iget v0, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mItemNameId:I

    return v0
.end method

.method public isEnabled()Z
    .locals 1

    .prologue
    .line 331
    iget-boolean v0, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mIsEnabled:Z

    return v0
.end method

.method public setEnabled(Z)V
    .locals 0
    .param p1, "isEnabled"    # Z

    .prologue
    .line 327
    iput-boolean p1, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mIsEnabled:Z

    .line 328
    return-void
.end method

.method public setItemName(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 355
    iput-object p1, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;->mItemName:Ljava/lang/String;

    .line 356
    return-void
.end method
