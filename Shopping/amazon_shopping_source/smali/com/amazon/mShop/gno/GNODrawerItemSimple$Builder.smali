.class public Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
.super Ljava/lang/Object;
.source "GNODrawerItemSimple.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawerItemSimple;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder",
        "<TT;>;>",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

.field private type:Lcom/amazon/mShop/gno/GNODrawerItem$Type;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 148
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 149
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    invoke-direct {v0, p1, p2}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    .line 150
    return-void
.end method

.method protected constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemSimple;)V
    .locals 0
    .param p1, "item"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    .prologue
    .line 152
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 153
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    .line 154
    return-void
.end method


# virtual methods
.method public build()Lcom/amazon/mShop/gno/GNODrawerItemSimple;
    .locals 2

    .prologue
    .line 158
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->type:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    if-eqz v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->type:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mType:Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->access$202(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .line 164
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    return-object v0

    .line 161
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    sget-object v1, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SIMPLE_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mType:Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    invoke-static {v0, v1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->access$202(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    goto :goto_0
.end method

.method protected self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 145
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<TT;>;"
    return-object p0
.end method

.method public withListener(Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
    .locals 1
    .param p1, "listener"    # Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 193
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mListener:Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
    invoke-static {v0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->access$102(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;

    .line 194
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    return-object v0
.end method

.method public withRefMarker(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
    .locals 1
    .param p1, "refMarker"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 178
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->setRefMarker(Ljava/lang/String;)V

    .line 179
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    return-object v0
.end method

.method public withSubView(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
    .locals 1
    .param p1, "resId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TT;"
        }
    .end annotation

    .prologue
    .line 188
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mSubViewId:I
    invoke-static {v0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->access$502(Lcom/amazon/mShop/gno/GNODrawerItemSimple;I)I

    .line 189
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    return-object v0
.end method

.method public withText(I)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
    .locals 1
    .param p1, "resId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TT;"
        }
    .end annotation

    .prologue
    .line 173
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mTextId:I
    invoke-static {v0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->access$402(Lcom/amazon/mShop/gno/GNODrawerItemSimple;I)I

    .line 174
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    return-object v0
.end method

.method public withText(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
    .locals 1
    .param p1, "text"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 168
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->item:Lcom/amazon/mShop/gno/GNODrawerItemSimple;

    # setter for: Lcom/amazon/mShop/gno/GNODrawerItemSimple;->mText:Ljava/lang/String;
    invoke-static {v0, p1}, Lcom/amazon/mShop/gno/GNODrawerItemSimple;->access$302(Lcom/amazon/mShop/gno/GNODrawerItemSimple;Ljava/lang/String;)Ljava/lang/String;

    .line 169
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    return-object v0
.end method

.method public withType(Lcom/amazon/mShop/gno/GNODrawerItem$Type;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;
    .locals 1
    .param p1, "type"    # Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/gno/GNODrawerItem$Type;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 183
    .local p0, "this":Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;, "Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder<TT;>;"
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->type:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .line 184
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;->self()Lcom/amazon/mShop/gno/GNODrawerItemSimple$Builder;

    move-result-object v0

    return-object v0
.end method
