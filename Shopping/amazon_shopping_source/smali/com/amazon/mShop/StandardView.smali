.class public Lcom/amazon/mShop/StandardView;
.super Landroid/widget/ScrollView;
.source "StandardView.java"

# interfaces
.implements Lcom/amazon/mShop/DelayedInitView;
.implements Lcom/amazon/mShop/TitleProvider;


# static fields
.field public static final NOT_FOUND:I = 0x0

.field public static final TITLE_ATTR_NAME:Ljava/lang/String; = "amazon_titleResourceId"


# instance fields
.field private initialized:Z

.field private final resources:Landroid/content/res/Resources;

.field private final titleResourceId:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    .line 43
    invoke-direct {p0, p1, p2}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 105
    iput-boolean v2, p0, Lcom/amazon/mShop/StandardView;->initialized:Z

    .line 44
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/StandardView;->resources:Landroid/content/res/Resources;

    .line 45
    const/4 v0, 0x0

    const-string/jumbo v1, "amazon_titleResourceId"

    invoke-interface {p2, v0, v1, v2}, Landroid/util/AttributeSet;->getAttributeResourceValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/StandardView;->titleResourceId:I

    .line 46
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/Integer;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "titleResourceId"    # Ljava/lang/Integer;

    .prologue
    const/4 v0, 0x0

    .line 49
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 105
    iput-boolean v0, p0, Lcom/amazon/mShop/StandardView;->initialized:Z

    .line 50
    invoke-static {}, Lcom/amazon/mShop/util/LayoutUtils;->fillBoth()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/StandardView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 51
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/StandardView;->resources:Landroid/content/res/Resources;

    .line 52
    if-nez p2, :cond_0

    :goto_0
    iput v0, p0, Lcom/amazon/mShop/StandardView;->titleResourceId:I

    .line 53
    return-void

    .line 52
    :cond_0
    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result v0

    goto :goto_0
.end method

.method public static createStandardView(Ljava/lang/String;Landroid/content/Context;I)Lcom/amazon/mShop/StandardView;
    .locals 9
    .param p0, "className"    # Ljava/lang/String;
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "titleResourceId"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;,
            Ljava/lang/NoSuchMethodException;,
            Ljava/lang/InstantiationException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 73
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 74
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-class v4, Lcom/amazon/mShop/StandardView;

    invoke-virtual {v0, v4}, Ljava/lang/Class;->asSubclass(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v2

    .line 75
    .local v2, "standardViewClass":Ljava/lang/Class;, "Ljava/lang/Class<+Lcom/amazon/mShop/StandardView;>;"
    new-array v4, v8, [Ljava/lang/Class;

    const-class v5, Landroid/content/Context;

    aput-object v5, v4, v6

    const-class v5, Ljava/lang/Integer;

    aput-object v5, v4, v7

    invoke-virtual {v2, v4}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v1

    .line 76
    .local v1, "ctor":Ljava/lang/reflect/Constructor;, "Ljava/lang/reflect/Constructor<+Lcom/amazon/mShop/StandardView;>;"
    new-array v4, v8, [Ljava/lang/Object;

    aput-object p1, v4, v6

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-virtual {v1, v4}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/StandardView;

    .line 77
    .local v3, "view":Lcom/amazon/mShop/StandardView;
    return-object v3
.end method


# virtual methods
.method public getContentView()Landroid/view/View;
    .locals 1

    .prologue
    .line 171
    const/4 v0, 0x0

    invoke-super {p0, v0}, Landroid/widget/ScrollView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 2

    .prologue
    .line 88
    iget v0, p0, Lcom/amazon/mShop/StandardView;->titleResourceId:I

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/StandardView;->resources:Landroid/content/res/Resources;

    iget v1, p0, Lcom/amazon/mShop/StandardView;->titleResourceId:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 91
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 128
    invoke-super {p0}, Landroid/widget/ScrollView;->onFinishInflate()V

    .line 129
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/StandardView;->presentLoadingIndicator(Z)V

    .line 130
    return-void
.end method

.method public onPushViewCompleted()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 109
    iget-boolean v2, p0, Lcom/amazon/mShop/StandardView;->initialized:Z

    if-nez v2, :cond_1

    .line 110
    invoke-virtual {p0}, Lcom/amazon/mShop/StandardView;->getChildCount()I

    move-result v1

    .line 111
    .local v1, "count":I
    if-nez v1, :cond_2

    .line 112
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/StandardView;->presentLoadingIndicator(Z)V

    .line 122
    :cond_0
    :goto_0
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/amazon/mShop/StandardView;->initialized:Z

    .line 124
    .end local v1    # "count":I
    :cond_1
    return-void

    .line 114
    .restart local v1    # "count":I
    :cond_2
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/StandardView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 115
    .local v0, "child":Landroid/view/View;
    instance-of v2, v0, Lcom/amazon/mShop/DelayedInitView;

    if-eqz v2, :cond_3

    .line 116
    check-cast v0, Lcom/amazon/mShop/DelayedInitView;

    .end local v0    # "child":Landroid/view/View;
    invoke-interface {v0}, Lcom/amazon/mShop/DelayedInitView;->onPushViewCompleted()V

    goto :goto_0

    .line 118
    .restart local v0    # "child":Landroid/view/View;
    :cond_3
    instance-of v2, v0, Landroid/view/ViewStub;

    if-eqz v2, :cond_0

    .line 119
    check-cast v0, Landroid/view/ViewStub;

    .end local v0    # "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/ViewStub;->inflate()Landroid/view/View;

    goto :goto_0
.end method

.method public presentLoadingIndicator(Z)V
    .locals 2
    .param p1, "replaceIfNotEmpty"    # Z

    .prologue
    .line 138
    if-eqz p1, :cond_1

    .line 139
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->loading_indicator:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/StandardView;->setContentView(I)V

    .line 146
    :cond_0
    :goto_0
    return-void

    .line 141
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/StandardView;->getChildCount()I

    move-result v0

    .line 142
    .local v0, "count":I
    if-nez v0, :cond_0

    .line 143
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->loading_indicator:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/StandardView;->setContentView(I)V

    goto :goto_0
.end method

.method public replaceLoadingIndicator(I)V
    .locals 4
    .param p1, "viewLayoutId"    # I

    .prologue
    .line 155
    invoke-virtual {p0}, Lcom/amazon/mShop/StandardView;->getChildCount()I

    move-result v0

    .line 156
    .local v0, "count":I
    if-nez v0, :cond_1

    .line 157
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/StandardView;->setContentView(I)V

    .line 164
    :cond_0
    :goto_0
    return-void

    .line 159
    :cond_1
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/StandardView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 160
    .local v1, "view":Landroid/view/View;
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->loading_indicator:I

    invoke-virtual {v1}, Landroid/view/View;->getId()I

    move-result v3

    if-ne v2, v3, :cond_0

    .line 161
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/StandardView;->setContentView(I)V

    goto :goto_0
.end method

.method public setContentView(I)V
    .locals 2
    .param p1, "viewLayoutId"    # I

    .prologue
    .line 190
    invoke-super {p0}, Landroid/widget/ScrollView;->removeAllViews()V

    .line 191
    invoke-virtual {p0}, Lcom/amazon/mShop/StandardView;->getContext()Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, p1, v1}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/widget/ScrollView;->addView(Landroid/view/View;)V

    .line 192
    return-void
.end method

.method public setContentView(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 180
    invoke-super {p0}, Landroid/widget/ScrollView;->removeAllViews()V

    .line 181
    invoke-super {p0, p1}, Landroid/widget/ScrollView;->addView(Landroid/view/View;)V

    .line 182
    return-void
.end method
