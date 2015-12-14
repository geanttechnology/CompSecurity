.class public Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;
.super Landroid/widget/BaseAdapter;
.source "CommentsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/CommentsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "CommentsListAdapter"
.end annotation


# instance fields
.field private activity:Landroid/app/Activity;

.field private comments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private inflater:Landroid/view/LayoutInflater;

.field final synthetic this$0:Lcom/livemixtapes/CommentsActivity;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/CommentsActivity;Landroid/app/Activity;Ljava/util/List;)V
    .locals 0
    .param p2, "activity"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/List",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 258
    .local p3, "comments":Ljava/util/List;, "Ljava/util/List<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    iput-object p1, p0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->this$0:Lcom/livemixtapes/CommentsActivity;

    .line 257
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 259
    iput-object p2, p0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->activity:Landroid/app/Activity;

    .line 260
    iput-object p3, p0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->comments:Ljava/util/List;

    .line 261
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 265
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->comments:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "location"    # I

    .prologue
    .line 270
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->comments:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 275
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 11
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 281
    iget-object v8, p0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->inflater:Landroid/view/LayoutInflater;

    if-nez v8, :cond_0

    .line 282
    iget-object v8, p0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->activity:Landroid/app/Activity;

    .line 283
    const-string v9, "layout_inflater"

    invoke-virtual {v8, v9}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/view/LayoutInflater;

    .line 282
    iput-object v8, p0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 284
    :cond_0
    if-nez p2, :cond_1

    .line 285
    iget-object v8, p0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 286
    const v9, 0x7f03001d

    const/4 v10, 0x0

    invoke-virtual {v8, v9, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 288
    :cond_1
    const v8, 0x7f080074

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 290
    .local v7, "userTv":Landroid/widget/TextView;
    const v8, 0x7f080063

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 289
    check-cast v1, Landroid/widget/TextView;

    .line 291
    .local v1, "commentTv":Landroid/widget/TextView;
    const v8, 0x7f080075

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 293
    .local v3, "dateTv":Landroid/widget/TextView;
    iget-object v8, p0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;->comments:Ljava/util/List;

    invoke-interface {v8, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    .line 295
    .local v0, "commentMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v8, "username"

    invoke-virtual {v0, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/CharSequence;

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 296
    const-string v8, "comment"

    invoke-virtual {v0, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/CharSequence;

    invoke-virtual {v1, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 297
    new-instance v5, Ljava/text/SimpleDateFormat;

    .line 298
    const-string v8, "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"

    .line 297
    invoke-direct {v5, v8}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 299
    .local v5, "sdf":Ljava/text/SimpleDateFormat;
    const-string v8, "UTC"

    invoke-static {v8}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 302
    :try_start_0
    const-string v8, "timestamp"

    invoke-virtual {v0, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v5, v8}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    .line 303
    .local v2, "date":Ljava/util/Date;
    new-instance v6, Ljava/text/SimpleDateFormat;

    const-string v8, "dd MMM yyyy hh:mm:ss a"

    invoke-direct {v6, v8}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    .line 304
    .end local v5    # "sdf":Ljava/text/SimpleDateFormat;
    .local v6, "sdf":Ljava/text/SimpleDateFormat;
    :try_start_1
    invoke-static {}, Ljava/util/TimeZone;->getDefault()Ljava/util/TimeZone;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 305
    invoke-virtual {v6, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_1
    .catch Ljava/text/ParseException; {:try_start_1 .. :try_end_1} :catch_1

    move-object v5, v6

    .line 310
    .end local v2    # "date":Ljava/util/Date;
    .end local v6    # "sdf":Ljava/text/SimpleDateFormat;
    .restart local v5    # "sdf":Ljava/text/SimpleDateFormat;
    :goto_0
    return-object p2

    .line 306
    :catch_0
    move-exception v4

    .line 308
    .local v4, "e":Ljava/text/ParseException;
    :goto_1
    invoke-virtual {v4}, Ljava/text/ParseException;->printStackTrace()V

    goto :goto_0

    .line 306
    .end local v4    # "e":Ljava/text/ParseException;
    .end local v5    # "sdf":Ljava/text/SimpleDateFormat;
    .restart local v2    # "date":Ljava/util/Date;
    .restart local v6    # "sdf":Ljava/text/SimpleDateFormat;
    :catch_1
    move-exception v4

    move-object v5, v6

    .end local v6    # "sdf":Ljava/text/SimpleDateFormat;
    .restart local v5    # "sdf":Ljava/text/SimpleDateFormat;
    goto :goto_1
.end method
