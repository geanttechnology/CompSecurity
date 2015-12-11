.class public Lnet/tsz/afinal/FinalActivity;
.super Landroid/app/Activity;
.source "FinalActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private initView()V
    .locals 14

    .prologue
    .line 58
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v3

    .line 59
    .local v3, "fields":[Ljava/lang/reflect/Field;
    if-eqz v3, :cond_0

    array-length v10, v3

    if-lez v10, :cond_0

    .line 60
    array-length v11, v3

    const/4 v10, 0x0

    :goto_0
    if-lt v10, v11, :cond_1

    .line 94
    :cond_0
    return-void

    .line 60
    :cond_1
    aget-object v2, v3, v10

    .line 61
    .local v2, "field":Ljava/lang/reflect/Field;
    const-class v12, Lnet/tsz/afinal/annotation/view/ViewInject;

    invoke-virtual {v2, v12}, Ljava/lang/reflect/Field;->getAnnotation(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;

    move-result-object v9

    check-cast v9, Lnet/tsz/afinal/annotation/view/ViewInject;

    .line 62
    .local v9, "viewInject":Lnet/tsz/afinal/annotation/view/ViewInject;
    if-eqz v9, :cond_6

    .line 63
    invoke-interface {v9}, Lnet/tsz/afinal/annotation/view/ViewInject;->id()I

    move-result v8

    .line 65
    .local v8, "viewId":I
    const/4 v12, 0x1

    :try_start_0
    invoke-virtual {v2, v12}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 66
    invoke-virtual {p0, v8}, Lnet/tsz/afinal/FinalActivity;->findViewById(I)Landroid/view/View;

    move-result-object v12

    invoke-virtual {v2, p0, v12}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 71
    :goto_1
    invoke-interface {v9}, Lnet/tsz/afinal/annotation/view/ViewInject;->click()Ljava/lang/String;

    move-result-object v0

    .line 72
    .local v0, "clickMethod":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_2

    .line 73
    invoke-direct {p0, v2, v0}, Lnet/tsz/afinal/FinalActivity;->setViewClickListener(Ljava/lang/reflect/Field;Ljava/lang/String;)V

    .line 75
    :cond_2
    invoke-interface {v9}, Lnet/tsz/afinal/annotation/view/ViewInject;->longClick()Ljava/lang/String;

    move-result-object v6

    .line 76
    .local v6, "longClickMethod":Ljava/lang/String;
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_3

    .line 77
    invoke-direct {p0, v2, v6}, Lnet/tsz/afinal/FinalActivity;->setViewLongClickListener(Ljava/lang/reflect/Field;Ljava/lang/String;)V

    .line 79
    :cond_3
    invoke-interface {v9}, Lnet/tsz/afinal/annotation/view/ViewInject;->itemClick()Ljava/lang/String;

    move-result-object v4

    .line 80
    .local v4, "itemClickMethod":Ljava/lang/String;
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_4

    .line 81
    invoke-direct {p0, v2, v4}, Lnet/tsz/afinal/FinalActivity;->setItemClickListener(Ljava/lang/reflect/Field;Ljava/lang/String;)V

    .line 83
    :cond_4
    invoke-interface {v9}, Lnet/tsz/afinal/annotation/view/ViewInject;->itemLongClick()Ljava/lang/String;

    move-result-object v5

    .line 84
    .local v5, "itemLongClickMethod":Ljava/lang/String;
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_5

    .line 85
    invoke-direct {p0, v2, v5}, Lnet/tsz/afinal/FinalActivity;->setItemLongClickListener(Ljava/lang/reflect/Field;Ljava/lang/String;)V

    .line 87
    :cond_5
    invoke-interface {v9}, Lnet/tsz/afinal/annotation/view/ViewInject;->select()Lnet/tsz/afinal/annotation/view/Select;

    move-result-object v7

    .line 88
    .local v7, "select":Lnet/tsz/afinal/annotation/view/Select;
    invoke-interface {v7}, Lnet/tsz/afinal/annotation/view/Select;->selected()Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v12

    if-nez v12, :cond_6

    .line 89
    invoke-interface {v7}, Lnet/tsz/afinal/annotation/view/Select;->selected()Ljava/lang/String;

    move-result-object v12

    invoke-interface {v7}, Lnet/tsz/afinal/annotation/view/Select;->noSelected()Ljava/lang/String;

    move-result-object v13

    invoke-direct {p0, v2, v12, v13}, Lnet/tsz/afinal/FinalActivity;->setViewSelectListener(Ljava/lang/reflect/Field;Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    .end local v0    # "clickMethod":Ljava/lang/String;
    .end local v4    # "itemClickMethod":Ljava/lang/String;
    .end local v5    # "itemLongClickMethod":Ljava/lang/String;
    .end local v6    # "longClickMethod":Ljava/lang/String;
    .end local v7    # "select":Lnet/tsz/afinal/annotation/view/Select;
    .end local v8    # "viewId":I
    :cond_6
    add-int/lit8 v10, v10, 0x1

    goto :goto_0

    .line 67
    .restart local v8    # "viewId":I
    :catch_0
    move-exception v1

    .line 68
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method

.method private setItemClickListener(Ljava/lang/reflect/Field;Ljava/lang/String;)V
    .locals 3
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "itemClickMethod"    # Ljava/lang/String;

    .prologue
    .line 121
    :try_start_0
    invoke-virtual {p1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 122
    .local v1, "obj":Ljava/lang/Object;
    instance-of v2, v1, Landroid/widget/AbsListView;

    if-eqz v2, :cond_0

    .line 123
    check-cast v1, Landroid/widget/AbsListView;

    .end local v1    # "obj":Ljava/lang/Object;
    new-instance v2, Lnet/tsz/afinal/annotation/view/EventListener;

    invoke-direct {v2, p0}, Lnet/tsz/afinal/annotation/view/EventListener;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v2, p2}, Lnet/tsz/afinal/annotation/view/EventListener;->itemClick(Ljava/lang/String;)Lnet/tsz/afinal/annotation/view/EventListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/AbsListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 128
    :cond_0
    :goto_0
    return-void

    .line 125
    :catch_0
    move-exception v0

    .line 126
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private setItemLongClickListener(Ljava/lang/reflect/Field;Ljava/lang/String;)V
    .locals 3
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "itemClickMethod"    # Ljava/lang/String;

    .prologue
    .line 132
    :try_start_0
    invoke-virtual {p1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 133
    .local v1, "obj":Ljava/lang/Object;
    instance-of v2, v1, Landroid/widget/AbsListView;

    if-eqz v2, :cond_0

    .line 134
    check-cast v1, Landroid/widget/AbsListView;

    .end local v1    # "obj":Ljava/lang/Object;
    new-instance v2, Lnet/tsz/afinal/annotation/view/EventListener;

    invoke-direct {v2, p0}, Lnet/tsz/afinal/annotation/view/EventListener;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v2, p2}, Lnet/tsz/afinal/annotation/view/EventListener;->itemLongClick(Ljava/lang/String;)Lnet/tsz/afinal/annotation/view/EventListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/AbsListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 139
    :cond_0
    :goto_0
    return-void

    .line 136
    :catch_0
    move-exception v0

    .line 137
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private setViewClickListener(Ljava/lang/reflect/Field;Ljava/lang/String;)V
    .locals 3
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "clickMethod"    # Ljava/lang/String;

    .prologue
    .line 99
    :try_start_0
    invoke-virtual {p1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 100
    .local v1, "obj":Ljava/lang/Object;
    instance-of v2, v1, Landroid/view/View;

    if-eqz v2, :cond_0

    .line 101
    check-cast v1, Landroid/view/View;

    .end local v1    # "obj":Ljava/lang/Object;
    new-instance v2, Lnet/tsz/afinal/annotation/view/EventListener;

    invoke-direct {v2, p0}, Lnet/tsz/afinal/annotation/view/EventListener;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v2, p2}, Lnet/tsz/afinal/annotation/view/EventListener;->click(Ljava/lang/String;)Lnet/tsz/afinal/annotation/view/EventListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 106
    :cond_0
    :goto_0
    return-void

    .line 103
    :catch_0
    move-exception v0

    .line 104
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private setViewLongClickListener(Ljava/lang/reflect/Field;Ljava/lang/String;)V
    .locals 3
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "clickMethod"    # Ljava/lang/String;

    .prologue
    .line 110
    :try_start_0
    invoke-virtual {p1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 111
    .local v1, "obj":Ljava/lang/Object;
    instance-of v2, v1, Landroid/view/View;

    if-eqz v2, :cond_0

    .line 112
    check-cast v1, Landroid/view/View;

    .end local v1    # "obj":Ljava/lang/Object;
    new-instance v2, Lnet/tsz/afinal/annotation/view/EventListener;

    invoke-direct {v2, p0}, Lnet/tsz/afinal/annotation/view/EventListener;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v2, p2}, Lnet/tsz/afinal/annotation/view/EventListener;->longClick(Ljava/lang/String;)Lnet/tsz/afinal/annotation/view/EventListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 117
    :cond_0
    :goto_0
    return-void

    .line 114
    :catch_0
    move-exception v0

    .line 115
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private setViewSelectListener(Ljava/lang/reflect/Field;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "field"    # Ljava/lang/reflect/Field;
    .param p2, "select"    # Ljava/lang/String;
    .param p3, "noSelect"    # Ljava/lang/String;

    .prologue
    .line 143
    :try_start_0
    invoke-virtual {p1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 144
    .local v1, "obj":Ljava/lang/Object;
    instance-of v2, v1, Landroid/view/View;

    if-eqz v2, :cond_0

    .line 145
    check-cast v1, Landroid/widget/AbsListView;

    .end local v1    # "obj":Ljava/lang/Object;
    new-instance v2, Lnet/tsz/afinal/annotation/view/EventListener;

    invoke-direct {v2, p0}, Lnet/tsz/afinal/annotation/view/EventListener;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v2, p2}, Lnet/tsz/afinal/annotation/view/EventListener;->select(Ljava/lang/String;)Lnet/tsz/afinal/annotation/view/EventListener;

    move-result-object v2

    invoke-virtual {v2, p3}, Lnet/tsz/afinal/annotation/view/EventListener;->noSelect(Ljava/lang/String;)Lnet/tsz/afinal/annotation/view/EventListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/AbsListView;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 150
    :cond_0
    :goto_0
    return-void

    .line 147
    :catch_0
    move-exception v0

    .line 148
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 33
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 34
    return-void
.end method

.method public setContentView(I)V
    .locals 0
    .param p1, "layoutResID"    # I

    .prologue
    .line 38
    invoke-super {p0, p1}, Landroid/app/Activity;->setContentView(I)V

    .line 39
    invoke-direct {p0}, Lnet/tsz/afinal/FinalActivity;->initView()V

    .line 40
    return-void
.end method

.method public setContentView(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 51
    invoke-super {p0, p1}, Landroid/app/Activity;->setContentView(Landroid/view/View;)V

    .line 52
    invoke-direct {p0}, Lnet/tsz/afinal/FinalActivity;->initView()V

    .line 53
    return-void
.end method

.method public setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 44
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 45
    invoke-direct {p0}, Lnet/tsz/afinal/FinalActivity;->initView()V

    .line 46
    return-void
.end method
