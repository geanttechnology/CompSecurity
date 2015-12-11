.class public abstract Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;
.super Landroid/widget/BaseAdapter;
.source "SourceFile"

# interfaces
.implements Landroid/widget/ListAdapter;
.implements Lcom/exacttarget/etpushsdk/event/CloudPagesChangedEventListener;


# static fields
.field public static final DISPLAY_ALL:I = 0x0

.field public static final DISPLAY_READ:I = 0x2

.field public static final DISPLAY_UNREAD:I = 0x1

.field private static final TAG:Ljava/lang/String; = "~!CloudPageListAdapter"


# instance fields
.field private allMessages:Ljava/util/List;

.field private applicationContext:Landroid/content/Context;

.field private display:I

.field private readMessages:Ljava/util/List;

.field private uiHandler:Landroid/os/Handler;

.field private unreadMessages:Ljava/util/List;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->allMessages:Ljava/util/List;

    .line 44
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->unreadMessages:Ljava/util/List;

    .line 45
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->readMessages:Ljava/util/List;

    .line 51
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->applicationContext:Landroid/content/Context;

    .line 52
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->uiHandler:Landroid/os/Handler;

    .line 53
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/exacttarget/etpushsdk/util/EventBus;->register(Ljava/lang/Object;)V

    .line 54
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->reloadData()V

    .line 55
    return-void
.end method

.method private reloadData()V
    .locals 6

    .prologue
    .line 133
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->allMessages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 134
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->unreadMessages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 135
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->readMessages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 138
    :try_start_0
    const-string v0, "message_type = ? AND content_type = ? AND message_deleted = ?"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lcom/exacttarget/etpushsdk/data/Message;->b:Ljava/lang/Integer;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    sget-object v3, Lcom/exacttarget/etpushsdk/data/Message;->i:Ljava/lang/Integer;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    const-string v3, "0"

    aput-object v3, v1, v2

    const/4 v2, 0x0

    const/4 v3, 0x0

    const-string v4, "start_date DESC "

    invoke-static {v0, v1, v2, v3, v4}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 148
    const-string v1, "~!CloudPageListAdapter"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "CloudPage Messages retrieved: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 150
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->allMessages:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 151
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 152
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Message;

    .line 153
    sget-object v3, Lcom/exacttarget/etpushsdk/data/Message;->b:Ljava/lang/Integer;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Message;->getMessageType()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    sget-object v3, Lcom/exacttarget/etpushsdk/data/Message;->i:Ljava/lang/Integer;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Message;->getContentType()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Message;->getEndDate()Ljava/util/Date;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Message;->getEndDate()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 154
    :cond_1
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Message;->getRead()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 155
    const-string v3, "~!CloudPageListAdapter"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Adding read CloudPage message: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Message;->getSubject()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 156
    iget-object v3, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->readMessages:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 163
    :catch_0
    move-exception v0

    .line 164
    const-string v1, "~!CloudPageListAdapter"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 166
    :cond_2
    return-void

    .line 158
    :cond_3
    :try_start_1
    const-string v3, "~!CloudPageListAdapter"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Adding unread CloudPage message: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Message;->getSubject()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 159
    iget-object v3, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->unreadMessages:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method


# virtual methods
.method public deleteMessage(Lcom/exacttarget/etpushsdk/data/Message;)V
    .locals 3

    .prologue
    .line 222
    :try_start_0
    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {p1, v0}, Lcom/exacttarget/etpushsdk/data/Message;->setMessageDeleted(Ljava/lang/Boolean;)V

    .line 223
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/database/e;->c(Lcom/exacttarget/etpushsdk/data/Message;)I

    .line 224
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->notifyDataSetChanged()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 228
    :goto_0
    return-void

    .line 225
    :catch_0
    move-exception v0

    .line 226
    const-string v1, "~!CloudPageListAdapter"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected finalize()V
    .locals 1

    .prologue
    .line 59
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/exacttarget/etpushsdk/util/EventBus;->unregister(Ljava/lang/Object;)V

    .line 60
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 61
    return-void
.end method

.method public getCount()I
    .locals 2

    .prologue
    .line 81
    const/4 v0, 0x0

    .line 83
    iget v1, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->display:I

    packed-switch v1, :pswitch_data_0

    .line 95
    :goto_0
    return v0

    .line 85
    :pswitch_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->allMessages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0

    .line 88
    :pswitch_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->unreadMessages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0

    .line 91
    :pswitch_2
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->readMessages:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0

    .line 83
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public getDisplay()I
    .locals 1

    .prologue
    .line 169
    iget v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->display:I

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 2

    .prologue
    .line 102
    const/4 v0, 0x0

    .line 103
    iget v1, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->display:I

    packed-switch v1, :pswitch_data_0

    .line 115
    :goto_0
    return-object v0

    .line 105
    :pswitch_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->allMessages:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Message;

    goto :goto_0

    .line 108
    :pswitch_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->unreadMessages:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Message;

    goto :goto_0

    .line 111
    :pswitch_2
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->readMessages:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Message;

    goto :goto_0

    .line 103
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public getItemId(I)J
    .locals 2

    .prologue
    .line 123
    int-to-long v0, p1

    return-wide v0
.end method

.method public notifyDataSetChanged()V
    .locals 0

    .prologue
    .line 128
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->reloadData()V

    .line 129
    invoke-super {p0}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    .line 130
    return-void
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/CloudPagesChangedEvent;)V
    .locals 2

    .prologue
    .line 69
    const-string v0, "~!CloudPageListAdapter"

    const-string v1, "CloudPage Messages reset adapter"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 70
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->uiHandler:Landroid/os/Handler;

    new-instance v1, Lcom/exacttarget/etpushsdk/adapter/a;

    invoke-direct {v1, p0}, Lcom/exacttarget/etpushsdk/adapter/a;-><init>(Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 75
    return-void
.end method

.method public setDisplay(I)V
    .locals 5

    .prologue
    .line 178
    const-string v0, "~!CloudPageListAdapter"

    const-string v1, "CloudPage changing display from %d to %d: "

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget v4, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->display:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 179
    iget v0, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->display:I

    if-eq v0, p1, :cond_0

    .line 180
    iput p1, p0, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->display:I

    .line 181
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->notifyDataSetChanged()V

    .line 183
    :cond_0
    return-void
.end method

.method public setMessageRead(Lcom/exacttarget/etpushsdk/data/Message;)V
    .locals 3

    .prologue
    .line 191
    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {p1, v0}, Lcom/exacttarget/etpushsdk/data/Message;->setRead(Ljava/lang/Boolean;)V

    .line 193
    :try_start_0
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/database/e;->c(Lcom/exacttarget/etpushsdk/data/Message;)I

    .line 194
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->notifyDataSetChanged()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 198
    :goto_0
    return-void

    .line 195
    :catch_0
    move-exception v0

    .line 196
    const-string v1, "~!CloudPageListAdapter"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public setMessageUnread(Lcom/exacttarget/etpushsdk/data/Message;)V
    .locals 3

    .prologue
    .line 206
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {p1, v0}, Lcom/exacttarget/etpushsdk/data/Message;->setRead(Ljava/lang/Boolean;)V

    .line 208
    :try_start_0
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/database/e;->c(Lcom/exacttarget/etpushsdk/data/Message;)I

    .line 209
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/adapter/CloudPageListAdapter;->notifyDataSetChanged()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 213
    :goto_0
    return-void

    .line 210
    :catch_0
    move-exception v0

    .line 211
    const-string v1, "~!CloudPageListAdapter"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
